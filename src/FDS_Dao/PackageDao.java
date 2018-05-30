class PackageDao {

    private String service_code;    //服务包物价编码
    private String service_name;    //服务包名称
    private String service_type;    //服务包类型，b基本包，z增值包
    private String service_level;   //服务包级别，q区级，j机构级，t团队级
    private String service_desc;    //服务包描述
    private String service_status;  //启停状态，q启用，t停用
    private String service_fee; //服务包费用
    private String service_item_name;   //项目名称

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_level() {
        return service_level;
    }

    public void setService_level(String service_level) {
        this.service_level = service_level;
    }

    public String getService_desc() {
        return service_desc;
    }

    public void setService_desc(String service_desc) {
        this.service_desc = service_desc;
    }

    public String getService_status() {
        return service_status;
    }

    public void setService_status(String service_status) {
        this.service_status = service_status;
    }

    public String getService_fee() {
        return service_fee;
    }

    public void setService_fee(String service_fee) {
        this.service_fee = service_fee;
    }

    public String getService_item_name() {
        return service_item_name;
    }

    public void setService_item_name(String service_item_name) {
        this.service_item_name = service_item_name;
    }

}
