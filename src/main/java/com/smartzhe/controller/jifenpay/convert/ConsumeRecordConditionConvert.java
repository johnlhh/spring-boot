package com.smartzhe.controller.jifenpay.convert;

import com.smartzhe.controller.jifenpay.request.*;
import com.smartzhe.jifenpay.entity.ConsumeRecordCondition;
import com.smartzhe.jifenpay.entity.enums.SorModeEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/31
 * Time: 20:01  .
 */
public class ConsumeRecordConditionConvert {

    public static ConsumeRecordCondition convertFindRequest(ConsumeRecordFindRequest request) {
        ConsumeRecordCondition condition = null;
        if (request != null) {
            condition = new ConsumeRecordCondition();
            condition.setIdStart(request.getIdStart());
            condition.setIdGT(request.getIdGT());
            condition.setIdLT(request.getIdLT());
            condition.setOwnerMemberId(request.getOwnerMemberId());
            condition.setPayerMemberId(request.getPayerMemberId());
            condition.setPayerMemberIdList(request.getPayerMemberIdStr() == null
                    ? null :
                    Arrays.asList(request.getPayerMemberIdStr().split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList()));

            condition.setOwnerMemberIdList(request.getOwnerMemberIds() == null
                    ? null :
                    Arrays.asList(request.getOwnerMemberIds().split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList()));


            condition.setAssetCodeList(request.getAssetCodeIn() == null ? null : Arrays.asList(request.getAssetCodeIn().split(",")));
            condition.setPayeeMemberId(request.getPayeeMemberId());
            condition.setPayerAccountId(request.getPayerAccountId());
            condition.setEnterpriseId(request.getEnterpriseId());
            condition.setAppId(request.getAppId());
            condition.setSourceAppId(request.getSourceAppId());
            condition.setPayeeMemberType(request.getPayeeMemberType());
            condition.setPayerMemberType(request.getPayerMemberType());

            condition.setTradeNo(request.getTradeNo());
            condition.setOuterTradeNo(request.getOuterTradeNo());
            condition.setContainFeeTrade(request.getContainFeeTrade());

            condition.setTimeCreatedEnd(request.getTimeCreatedEnd());
            condition.setTimeCreatedStart(request.getTimeCreatedStart());
            condition.setTimeCreatedFrom(request.getTimeCreatedFrom());
            condition.setTimeCreatedTo(request.getTimeCreatedTo());
            condition.setPointAmtStart(request.getPointAmtStart());
            condition.setPointAmtEnd(request.getPointAmtEnd());
            condition.setPayType(request.getPayType());
            condition.setContainFeeTrade(request.getContainFeeTrade());
            condition.setRemarkLike(request.getRemarkLike());
            converPageRequest(condition, request);
        }
        return condition;
    }

    public static ConsumeRecordCondition convertStatInfoRequest(ConsumeRecordStatInfoRequest request) {
        ConsumeRecordCondition condition = null;
        if (request != null) {
            condition = new ConsumeRecordCondition();
            condition.setOwnerMemberId(request.getOwnerMemberId());
            condition.setPayerMemberId(request.getPayerMemberId());
            condition.setPayerMemberIdList(request.getPayerMemberIdStr() == null
                    ? null :
                    Arrays.asList(request.getPayerMemberIdStr().split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList()));

            condition.setAssetCodeList(request.getAssetCodeIn() == null ? null : Arrays.asList(request.getAssetCodeIn().split(",")));
            condition.setPayeeMemberId(request.getPayeeMemberId());

            condition.setEnterpriseId(request.getEnterpriseId());
            condition.setAppId(request.getAppId());
            condition.setSourceAppId(request.getSourceAppId());
            condition.setPayeeMemberType(request.getPayeeMemberType());
            condition.setPayerMemberType(request.getPayerMemberType());

            condition.setTradeNo(request.getTradeNo());
            condition.setOuterTradeNo(request.getOuterTradeNo());

            condition.setTimeCreatedEnd(request.getTimeCreatedEnd());
            condition.setTimeCreatedStart(request.getTimeCreatedStart());
            condition.setTimeCreatedFrom(request.getTimeCreatedFrom());
            condition.setTimeCreatedTo(request.getTimeCreatedTo());
            condition.setPointAmtStart(request.getPointAmtStart());
            condition.setPointAmtEnd(request.getPointAmtEnd());

        }
        return condition;
    }

    public static ConsumeRecordCondition convertGetAllByOwnerIdRequest(ConsumeRecordGetAllByOwnerIdRequest request) {
        ConsumeRecordCondition condition = null;
        if (request != null) {
            condition = new ConsumeRecordCondition();
            condition.setOwnerMemberId(request.getOwnerMemberId());
            condition.setAppId(request.getAppId());
            condition.setSourceAppId(request.getSourceAppId());
            condition.setTimeCreatedEnd(request.getTimeCreatedEnd());
            condition.setTimeCreatedStart(request.getTimeCreatedStart());
            converPageRequest(condition, request);
        }
        return condition;
    }


    public static ConsumeRecordCondition convertGetAllByEnterpriseIdRequest(ConsumeRecordGetAllByEnterpriseIdRequest request) {
        ConsumeRecordCondition condition = null;
        if (request != null) {
            condition = new ConsumeRecordCondition();
            condition.setEnterpriseId(request.getEnterpriseId());
            condition.setAppId(request.getAppId());
            condition.setSourceAppId(request.getSourceAppId());
            condition.setTimeCreatedEnd(request.getTimeCreatedEnd());
            condition.setTimeCreatedStart(request.getTimeCreatedStart());
            converPageRequest(condition, request);
        }
        return condition;
    }

    public static void converPageRequest(ConsumeRecordCondition condition, PageRequest request) {
        if (request.getPage() == null || Integer.compare(request.getPage(), 0) == 0) {
            condition.setPage(1);
        } else {
            condition.setPage(request.getPage());
        }
        if (request.getRowsPerPage() == null || Integer.compare(request.getRowsPerPage(), 0) == 0) {
            condition.setRowsPerPage(100);
        } else {
            condition.setRowsPerPage(request.getRowsPerPage());
        }
        if (request.getSorModeEnum() == null) {
            condition.setSorModeEnum(SorModeEnum.ID_ASC);
        } else {
            condition.setSorModeEnum(request.getSorModeEnum());
        }
    }

}
