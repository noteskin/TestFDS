class ItemDao {

    //项目编码
    private String item_code;
    //项目名称
    private String item_name;
    //项目描述
    private String item_desc;
    //展现方式 0：s数值结果，1：m描述文本，2：l页面链接
    private String show_type;
    //是否允许录入 0：n否，1：y是
    private String  allow_entry;
    //停启状态 1：q启用，2：t停用
    private String item_status;

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getShow_type() {
        return show_type;
    }

    public void setShow_type(String show_type) {
        this.show_type = show_type;
    }

    public String getAllow_entry() {
        return allow_entry;
    }

    public void setAllow_entry(String allow_entry) {
        this.allow_entry = allow_entry;
    }

    public String getItem_status() {
        return item_status;
    }

    public void setItem_status(String item_status) {
        this.item_status = item_status;
    }
}


