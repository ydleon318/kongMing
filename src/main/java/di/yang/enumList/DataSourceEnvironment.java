package di.yang.enumList;




public enum DataSourceEnvironment {
    ZHANGWU_245("172.16.131.245"),ZHANGWU_6("172.16.131.6");

    private String msg;

    DataSourceEnvironment(String msg) {
        this.msg = msg;
    }

    public String getMsgName() {
        return this.msg;
    }

    public static DataSourceEnvironment getEnviron(String name){
        for (DataSourceEnvironment environment : DataSourceEnvironment.values()){
            if (environment.getMsgName().equals(name)){
                return environment;
            }
        }
        return null;
    }


}
