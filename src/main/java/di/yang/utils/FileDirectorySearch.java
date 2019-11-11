package di.yang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class FileDirectorySearch {
    private Logger logger = LoggerFactory.getLogger(FileDirectorySearch.class);
    private ClassLoader classLoader;

    public FileDirectorySearch() {
        this.classLoader = getClass().getClassLoader();
    }
    /**
     *获取指定包下的所有字节码文件的全类名
     */
    public List<String>  getFullyQualifiedClassNameList(String basePackage) throws IOException {
        logger.info("开始扫描包{}下的所有类", basePackage);
        return doScan(basePackage, new ArrayList<String>());
    }

    private List<String> doScan(String basePackage, ArrayList<String> nameList) throws IOException {
        String splashPath = StringUtil.dotToSplash(basePackage);
        URL url = classLoader.getResource(splashPath);
        String filePath = StringUtil.getRootPath(url);
        List<String> names = null; // contains the name of the class file. e.g., Apple.class will be stored as "Apple"
        if (isJarFile(filePath)) {// 先判断是否是jar包，如果是jar包，通过JarInputStream产生的JarEntity去递归查询所有类
            logger.debug("{} 是一个JAR包", filePath);

            try {
                names = readFromJarFile(basePackage);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return names;
        } else {
            logger.debug("{} 是一个目录", filePath);
            names = readFromDirectory(filePath);
        }
        for (String name : names) {
            if (isClassFile(name)) {
                nameList.add(toFullyQualifiedName(name, basePackage));
            } else {
                doScan(basePackage + "." + name, nameList);
            }
        }
        return nameList;
    }

    private String toFullyQualifiedName(String shortName, String basePackage) {
        StringBuilder sb = new StringBuilder(basePackage);
        sb.append('.');
        sb.append(StringUtil.trimExtension(shortName));
        //打印出结果
        System.out.println(sb.toString());
        return sb.toString();
    }

    private List<String> readFromJarFile(String splashedPackageName) throws IOException, ClassNotFoundException {
        logger.debug("从JAR包中读取类: {}", splashedPackageName);
        List<String> nameList = new ArrayList<>();
        Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(splashedPackageName.replace(".", "/"));
        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();//得到的结果大概是：jar:file:/C:/Users/ibm/.m2/repository/junit/junit/4.12/junit-4.12.jar!/org/junit
            String protocol = url.getProtocol();//大概是jar
            if ("jar".equalsIgnoreCase(protocol)) {
                //转换为JarURLConnection
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                if (connection != null) {
                    JarFile jarFile = connection.getJarFile();
                    if (jarFile != null) {
                        //得到该jar文件下面的类实体
                        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                        while (jarEntryEnumeration.hasMoreElements()) {
                            /*entry的结果大概是这样：
                                    org/
                                    org/junit/
                                    org/junit/rules/
                                    org/junit/runners/*/
                            JarEntry entry = jarEntryEnumeration.nextElement();
                            String jarEntryName = entry.getName();
                            //这里我们需要过滤不是class文件和不在basePack包名下的类
                            if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/",".").startsWith(splashedPackageName)) {
                                String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                                Class cls = Class.forName(className);
                                nameList.add(cls.getName());
                            }
                        }
                    }
                }
            }
        }
        return nameList;
    }

    private List<String> readFromDirectory(String path) {
        File file = new File(path);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return Arrays.asList(names);
    }

    private boolean isClassFile(String name) {
        return name.endsWith(".class");
    }

    private boolean isJarFile(String name) {
        return name.endsWith(".jar");
    }


}
