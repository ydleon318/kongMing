package di.yang.enumList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangdi
 * @Date 2019/12/9 16:29
 **/
public enum WebOptMethod {
    openUrl("打开网页"),
    pause("暂停"),
    click("点击"),
    sendKey("输入"),
    selectByText("选择下拉列表文本"),
    closeURL("关闭网页"),
    getTitle("获取窗口title"),
    reFresh("刷新"),
    selectWindow("窗口切换"),
    Back("窗口回退"),
    forward("窗口前进"),
    closeWindow("关闭当前窗口"),
    closeAlter("关闭对话框"),
    closeAlertAndGetItsText("获取对话框文本并关闭");

    private String msg;

    WebOptMethod(String msg) {
        this.msg = msg;
    }

    public String getMsgName() {
        return this.msg;
    }

    public static WebOptMethod getmethod(String name){
        for (WebOptMethod weboptmethod : WebOptMethod.values()){
            if (weboptmethod.getMsgName().equals(name)){
                return weboptmethod;
            }
        }
        return null;
    }

    public static List<String> getWebOptMethodList(){
        List<String> weboptmethods = new ArrayList<String>();
        for (WebOptMethod weboptmethod : WebOptMethod.values()){
               weboptmethods.add(weboptmethod.getMsgName());
        }
        return weboptmethods;
    }
}
