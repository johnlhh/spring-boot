package com.smartzhe.controller.jifenpay;

import com.smartzhe.controller.jifenpay.convert.ConsumeRecordConditionConvert;
import com.smartzhe.controller.jifenpay.request.*;
import com.smartzhe.exception.BizException;
import com.smartzhe.exception.BizExceptionType;
import com.smartzhe.jifenpay.entity.ConsumeRecord;
import com.smartzhe.jifenpay.entity.ConsumeRecordCondition;
import com.smartzhe.jifenpay.entity.OuterTrade;
import com.smartzhe.model.ApiResponse;
import com.smartzhe.service.jifenpay.ConsumeRecordService;
import com.smartzhe.service.jifenpay.OuterTradeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 17:18  .
 */
@Slf4j
@RestController
@RequestMapping(value = "/pay/consumeRecord", method = RequestMethod.POST)
public class ConsumeRecordController {

    private static final String TAGS = "消费记录API";

    @Autowired
    private ConsumeRecordService consumeRecordService;

    @Autowired
    private OuterTradeService outerTradeService;

    @ApiOperation(value = "取单条消费记录", notes = "", tags = {TAGS})
    @ApiImplicitParam(name = "request", value = "", required = false, dataType = "ConsumeRecordGetRequst")
    @RequestMapping(value = "/get")
    public ApiResponse getConsumeRecord(@RequestBody ConsumeRecordGetRequst request) {
        if (request == null) {
            return null;
        }
        ConsumeRecord consumeRecord = new ConsumeRecord();
        if (request.getId() != null) {
            consumeRecord.setId(request.getId());
        } else if (!StringUtils.isEmpty(request.getTradeNo())) {
            consumeRecord.setTradeNo(request.getTradeNo());
        } else if (!StringUtils.isEmpty(request.getOuterTradeNo())) {
            String outerTradeNo = request.getOuterTradeNo();
            String appId = outerTradeNo.substring(0, 8);
            OuterTrade outerTrade = outerTradeService.getOuterTradeByAppIdAndOuterTradeNo(appId, outerTradeNo);
            consumeRecord.setTradeNo(outerTrade.getTradeNo());
        } else {
            throw new BizException(BizExceptionType.BIZ_EXCEPTION_CUSTOMER_NOT_UNIQUE_NAME);
        }
        return ApiResponse.success(consumeRecordService.getConsumeRecord(consumeRecord));
    }

    @ApiOperation(value = "按服务费交易号取单条消费记录信息", notes = "", tags = {TAGS})
    @ApiImplicitParam(name = "request", value = "", required = true, dataType = "ConsumeRecordGetByFeeTradeNoRequst")
    @RequestMapping(value = "/getByFeeTradeNo")
    public ApiResponse getConsumeRecordByFeeTradeNo(@RequestBody ConsumeRecordGetByFeeTradeNoRequst request) {

        return ApiResponse.success(consumeRecordService.getConsumeRecordByFeeTradeNo(request.getFeeTradeNo(), request.getOwnerMemberId()));
    }

    @ApiOperation(value = "取指定企业的消费记录", notes = "", tags = {TAGS})
    @ApiImplicitParam(name = "request", value = "", required = true, dataType = "ConsumeRecordGetAllByEnterpriseIdRequest")
    @RequestMapping(value = "/getAllByEnterpriseId")
    public ApiResponse getAllByEnterpriseId(@RequestBody ConsumeRecordGetAllByEnterpriseIdRequest request) {

        return ApiResponse.success(consumeRecordService.getAllByEnterpriseId(ConsumeRecordConditionConvert.convertGetAllByEnterpriseIdRequest(request)));
    }

    @ApiOperation(value = "取指定用户的消费记录", notes = "", tags = {TAGS})

    @RequestMapping(value = "/getAllByOwnerId")
    public ApiResponse getAllByOwnerId(@RequestBody ConsumeRecordGetAllByOwnerIdRequest request) {

        return ApiResponse.success(consumeRecordService.getAllByOwnerId(ConsumeRecordConditionConvert.convertGetAllByOwnerIdRequest(request)));
    }

    @ApiOperation(value = "按搜索条件取消费记录信息", notes = "", tags = {TAGS})
    @ApiImplicitParam(name = "request", value = "", required = true, dataType = "ConsumeRecordFindRequest")
    @RequestMapping("/find")
    public ApiResponse find(@RequestBody ConsumeRecordFindRequest request) {

        return ApiResponse.success(consumeRecordService.find(ConsumeRecordConditionConvert.convertFindRequest(request)));
    }

    @ApiOperation(value = "按条件统计消费信息", notes = "", tags = {TAGS})
    @ApiImplicitParam(name = "request", value = "", required = true, dataType = "ConsumeRecordStatInfoRequest")
    @RequestMapping("/statInfo")
    public ApiResponse statInfo(@RequestBody ConsumeRecordStatInfoRequest request) {

        if (request != null) {
            String outerTradeNo = request.getOuterTradeNo();
            if (outerTradeNo != null) {
                String appId = outerTradeNo.substring(0, 8);
                OuterTrade outerTrade = outerTradeService.getOuterTradeByAppIdAndOuterTradeNo(appId, outerTradeNo);
                if (outerTrade == null) {
                    return ApiResponse.fail();
                } else {
                    request.setTradeNo(outerTrade.getTradeNo());
                }
            }
        }
        return ApiResponse.success(consumeRecordService.statInfo(ConsumeRecordConditionConvert.convertStatInfoRequest(request)));
    }


}
