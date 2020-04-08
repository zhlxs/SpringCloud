package com.demo.sp.bean;

import com.demo.sp.annotation.FlagValidator;

public class PmsBrandParam
{
    //@ApiModelProperty(value = "是否进行显示")
    @FlagValidator(value = { "0", "1" }, message = "显示状态不正确")
    private Integer showStatus;
}
