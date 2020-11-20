package model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 费用基础
 * @Author      Allens
 * @Date        2020-10-27 16:12
 * @Version     V1.0
 */
@Setter
@Getter
public class BusinessFeeStandardParam implements Serializable {

    private static final long serialVersionUID = 7858991755653458300L;

    @ApiModelProperty(value = "费用类型(0: 应收, 1: 应付)")
    private String type;

    @ApiModelProperty(value = "产值部门")
    private String settleDeptCode;

    @ApiModelProperty(value = "产值部门名称")
    private String settleDeptName;

    @ApiModelProperty(value = "业务对象代码")
    private String businessCode;

    @ApiModelProperty(value = "业务对象名称")
    private String businessName;

    @ApiModelProperty(value = "费用开始时间")
    private String freightBeginDate;

    @ApiModelProperty(value = "费用结束时间")
    private String freightEndDate;

    @ApiModelProperty(value = "费用来源(1: 手动新增, 10: 订单新增, 20: 运价新增)")
    private String freightSource;

    @ApiModelProperty(value = "费用分类(10: 收入/成本, 20: 代垫, 30: 费用, 40: 佣金, 50: 押金)")
    private String feeCategory;

    @ApiModelProperty(value = "费用名称代码")
    private String freightCode;

    @ApiModelProperty(value = "费用名称")
    private String feeitem;

    @ApiModelProperty(value = "费用名称代码")
    private String feeItemCode;

    @ApiModelProperty(value = "撤票: Y 是 N 否  默认为N")
    private String isReplace;

    @ApiModelProperty(value = "代收代付互相关联用，收款存对应的付款费用ID，付款存对应的收款费用ID")
    private String replaceId;

    @ApiModelProperty(value = "是否现场结费（N：否；Y：是）默认N")
    private String isSpot;

    @ApiModelProperty(value = "数量")
    private String quantity;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "单价")
    private String unitPrice;

    @ApiModelProperty(value = "币别")
    private String currency;

    @ApiModelProperty(value = "金额")
    private String amount;

    @ApiModelProperty(value = "汇率")
    private String rate;

    @ApiModelProperty(value = "本位币币别")
    private String baseCurrencyCode;

    @ApiModelProperty(value = "本位币金额")
    private String baseCurrencyValue;

    @ApiModelProperty(value = "是否允许开票")
    private String isInvoice;

    @ApiModelProperty(value = "是否含税（Y：含税，N：不含税） 默认为Y")
    private String isTax;

    @ApiModelProperty(value = "是否免税 (Y：免税， N：不免税)")
    private String isTaxFree;

    @ApiModelProperty(value = "预计开票类型")
    private String estimatedInvoiceType;

    @ApiModelProperty(value = "不含税金额")
    private String estimatedAmount;

    @ApiModelProperty(value = "预估税率")
    private String estimatedTaxRate;

    @ApiModelProperty(value = "预估税金")
    private String estimatedTaxes;

    @ApiModelProperty(value = "箱ID")
    private String containerId;

    @ApiModelProperty(value = "箱号")
    private String ctnNo;

    @ApiModelProperty(value = "箱ID")
    private String ctnId;

    @ApiModelProperty(value = "箱型尺寸")
    private String ctn;

    @ApiModelProperty(value = "付款条款 ：PP预付 CC到付")
    private String payTerm;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "冲销类型（CM（cross month）跨月红字发票，FC（freight change）费用更正）")
    private String writeoffType;

    @ApiModelProperty(value = "冲销状态（N 默认， B 被冲销， W 冲销， A 增补）")
    private String writeoffStatus;

    @ApiModelProperty(value = "冲销原费用ID")
    private String writeoffId;

    @ApiModelProperty(value = "内配标识  Y是 N不是  默认合法性校验：Y、N")
    private String isInternalFrt;

    @ApiModelProperty(value = "内配类型 C 公司间内配 D 部门间内配")
    private String internalType;

    @ApiModelProperty(value = "内配部门")
    private String internalDeptCode;

    @ApiModelProperty(value = "内配部门名称")
    private String internalDeptName;

    @ApiModelProperty(value = "结算单位")
    private String customerName;

    @ApiModelProperty(value = "审核状态(\"false\": 未审核, \"true\": 已审核)")
    private String auditStatus;

    @ApiModelProperty(value = "审核时间")
    private String payAuditDate;

    @ApiModelProperty(value = "审核人员工编码")
    private String auditPersonCode;

    @ApiModelProperty(value = "审核员工名称")
    private String auditPersonName;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "最后修改人")
    private String modifyBy;

    @ApiModelProperty(value = "最后修改时间")
    private String modifyTime;

    @ApiModelProperty(value = "确认单号")
    private String confirmNo;

}
