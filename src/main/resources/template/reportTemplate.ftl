<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8"/>
		<title>货后报告</title>
		<meta name="renderer" content="webkit"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
		<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
		<meta name="apple-mobile-web-app-capable" content="yes"/>
		<meta name="format-detection" content="telephone=no"/>
		
		<style type="text/css">
			table,table tr th, table tr td { border:0px; }
			table {  min-height: 30px; line-height: 30px; text-align: center; border-collapse: collapse;}
			.label_underline{
				border:0px;border-bottom:#000000 1px solid;
			}
			span{
				display:inline-block;
			}
			label{
				display:inline-block;
			}
			.label_no_border{
				border:0px;
				outline:none;
			}
			
			.div_item{
				margin-top:5px;
			}
			
			.img_radio{
				width:30px;
				height:30px;
			}
			
			.md2{
				width:10%;
				display:inline-block;				
			}
			.md3{
				width:20%;
				display:inline-block;				
			}
			.md4{
				width:28%;
				display:inline-block;				
			}
			.md5{
				width:39%;
				display:inline-block;				
			}
			.md6{
				width:49.5%;
				display:inline-block;				
			}
			.md7{
				width:60%;
				display:inline-block;				
			}
			.md8{
				width:70%;
				display:inline-block;				
			}
			.md9{
				width:75%;
				display:inline-block;				
			}
			.md10{
				width:89%;
				display:inline-block;				
			}
			
			.md12{
				width:99%;
				display:inline-block;				
			}
		</style>
	</head>

	<body style="font-family: SimSun;margin:0px 0px;">
		<table width="100%;" style="text-align:left;">
			<tr>
				<td colspan="12">
					<h1 style="text-align:center;">中小企业贷后监管报告</h1>
				</td>
			</tr>
			<tr>
				<td colspan="12" style="text-align:center;">
					<span style="width:80px;text-align:center;" class="label_underline">${report.year}</span>
					年度
					<span style="width:35px;text-align:center;" class="label_underline">${report.reportNo}</span>
					月份贷后报告
				</td>		
			</tr>
			<tr>
				<td colspan="1">
					【检查人】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px;">
						${report.examiner.name}
					</span>
				</td>
				<td colspan="1">
					【检查日期】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px;">
						${report.examinTime}
					</span>
				</td>		
			</tr>
			<tr>
				<td colspan="12" style="">
					一、客户基本情况
				</td>		
			</tr>
			<tr>
				<td colspan="12" style="">
					1、客户概况：
				</td>		
			</tr>
			<tr>
				<td colspan="1">
					【客户名称】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px;">
						${customer.name}
					</span>
				</td>
				<td colspan="1">
					【经营地址】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px;">
						${customer.address}
					</span>
				</td>
			</tr>
			<tr>
				<td colspan="1">
					【实际控制人】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px">
						${customer.manager}
					</span>
				</td>
				<td colspan="1">
					【联系电话】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px">
						${customer.telphone}
					</span>
				</td>
			</tr>
			<tr>
				<td colspan="1">
					【行业类型】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px">
						${customer.industryType.name}
					</span>
				</td>
				<td colspan="1">
					【主营业务】
				</td>
				<td colspan="5">
					<span class="label_underline" style="text-align:center;width:320px">
						${customer.mainBusiness}
					</span>
				</td>
			</tr>
			<tr>
				<td colspan="12">
					【客户融资情况】
				</td>
			</tr>
			<tr>
				<td colspan="12">
					<table width="100%" style="table-layout:fixed;border:1px solid #000000;">
						<thead>
							<tr style="border:1px solid #000000;">
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;padding:0 0;">信贷品种</th>
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;">合同金额</th>
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;">当期余额</th>
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;">贷款起始日期</th>
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;">贷款截止日期</th>
								<th width="120px" style="border:1px solid #000000;word-wrap:break-word;">担保措施</th>
							</tr>
						</thead>
						<tbody style="border:1px solid #000000;">
							<#list reportFinanceItems as item>
								<tr style="border:1px solid #000000;">
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;" >
										${item.creditType.name}
									</td>
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										${item.contractAmount}
									</td>
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;"> 
										${item.currentBalance}
									</td>
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										${item.refundStartTime}
									</td>
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										${item.refundEndTime}
									</td>
									<td width="120px" style="border:1px solid #000000;white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										${item.guaranteeMeasures}
									</td>
								</tr>
							</#list>
							
						</tbody>
					</table>
				</td>		
			</tr>
			<tr>
				<td colspan="12">
					2、融资用途：
					<br/>（1）批准用途：<br/>
					<label class="label_underline" style="width:800px;">${reportFinance.financePurpose}</label>
					<br/>（2）实际用途：<br/>
					<label class="label_underline" style="width:800px;">${reportFinance.financePurposeActual}</label>
					<br/>（3）是否按规定用途使用：<br/>
					<#if reportFinance.usedByAllowed=="1" >  <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportFinance.usedByAllowed=="0" >  <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
					<br/>3、客户配套资金是否到位：<br/>
					<#if reportFinance.moneyInPlace=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportFinance.moneyInPlace=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
					<br/>4、还款记录是否正常：<br/>
						<#if reportFinance.repaymentState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportFinance.repaymentState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						是否不断申请延期支付或申请实施新的授信：
						<#if reportFinance.aplayDeferred=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是
						<#if reportFinance.aplayDeferred=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						短期债务是否超常增加：
						<#if reportFinance.debtState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是；
						<#if reportFinance.debtState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：<br/>
						<label style="text-align:left;width:800px;" class="label_underline" >${reportFinance.repaymentStateRemark}</label>
					<div class="div_item">
						<br/><label >5、其他金融机构授信金额合计：</label>
						<label  style="text-align:center;margin:0;width:185px;maxlength:8;" class="label_underline">${reportFinance.otherFinaceCreditAmount}</label>万元，其中：贷款
						<label  style="text-align:center;margin:0;width:185px;maxlength:8;" class="label_underline">${reportFinance.otherFinaceLoan}</label>万元，其他信贷品种及金额
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportFinance.otherFinaceOtherAmount}</label>
					</div>
					<div class="div_item">
						<label >6、有无不良贷款或不良记录：</label>
						<#if reportFinance.loanHasBadRecordState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，金额 
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportFinance.loanHasBadRecordAmount}</label>万元，
						<#if reportFinance.loanHasBadRecordState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						对外担保总额
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportFinance.outerGuaranteeLoanAmount}</label>万元，其中：保证担保
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportFinance.outerGuaranteeLoan}</label>万元，抵质押担保
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportFinance.outerGuaranteeLoanMortgage}</label>万元
					</div>
					<div class="div_item">
						<label >6、其他：</label>
						${reportFinance.reportFinanceOther}
					</div>
				</td>
			</tr>
			
			<tr>
				<td colspan="12">
					二、客户经营管理情况
					<div class="div_item">
						<label >1、主营业务是否发生变化：</label>
						<#if reportBusinessManage.mainBusinessChange=="1" >   <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.mainBusinessChange=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						生产经营是否正常：
						<#if reportBusinessManage.businessState=="1" >   <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.businessState=="0" >   <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						企业发展趋势：
						<#if reportBusinessManage.enterpriseTrend=="1" >   <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>优
						<#if reportBusinessManage.enterpriseTrend=="2" >    <img src="selected_1.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>良好
						<#if reportBusinessManage.enterpriseTrend=="3" >    <img src="selected_2.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>较好
						<#if reportBusinessManage.enterpriseTrend=="4" >    <img src="selected_3.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>一般
						<#if reportBusinessManage.enterpriseTrend=="5" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>恶化
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline">${reportBusinessManage.mainBusinessRemark}</label>
					</div>
					<div class="div_item">
						<label >2、管理层是否发生重大变化：</label>
						<#if reportBusinessManage.orginaltionChange=="1" >   <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.orginaltionChange=="0" >   <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否。
						影响情况：
						<#if reportBusinessManage.orgChangeEffect=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>无影响
						<#if reportBusinessManage.orgChangeEffect=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有正面影响
						<#if reportBusinessManage.orgChangeEffect=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有一定负面影响，但无法判断影响程度
						<#if reportBusinessManage.orgChangeEffect=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>将产生较大负面影响
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.orgChangeRemark}</label>
					</div>
					<div class="div_item">
						<label >3、主要股东、关联公司与母子公司是否发生重大变化：</label>
						<#if reportBusinessManage.shareholdersChange=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.shareholdersChange=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否。
						<br/>影响情况：
						<#if reportBusinessManage.shareholdersChangeEffect=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>无影响
						<#if reportBusinessManage.shareholdersChangeEffect=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有正面影响
						<#if reportBusinessManage.shareholdersChangeEffect=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有一定负面影响，但无法判断影响程度
						<#if reportBusinessManage.shareholdersChangeEffect=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>将产生较大负面影响
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.shareholdersChangeRemark}</label>
					</div>
					<div class="div_item">
						<label >4、客户内部管理情况：</label>
						<#if reportBusinessManage.customerManage=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>良好
						<#if reportBusinessManage.customerManage=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>一般
						<#if reportBusinessManage.customerManage=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>一般
						<#if reportBusinessManage.customerManage=="4" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有一定的问题，存在可能影响贷款偿还的因素
						<#if reportBusinessManage.customerManage=="5" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>管理混乱，阻碍贷款偿还
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.customerManageRemark}</label>
					</div>
					<div class="div_item">
						<label >5、是否发生重大诉讼或仲裁、重大事故或重大赔偿：</label>
						<#if reportBusinessManage.arbitrationState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.arbitrationState=="0" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否。
						<br/>影响情况：
						<#if reportBusinessManage.arbitrationStateEffect=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>无影响
						<#if reportBusinessManage.arbitrationStateEffect=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有正面影响
						<#if reportBusinessManage.arbitrationStateEffect=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有一定负面影响，但无法判断影响程度
						<#if reportBusinessManage.arbitrationStateEffect=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>将产生较大负面影响
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.arbitrationStateRemark}</label>
					</div>
					<div class="div_item">
						<label >6、外部经营环境是否发生不利经营的重大变化：</label>
						<#if reportBusinessManage.outerManage=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.outerManage=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						对竞争变化或外部条件变化是否有应对措施：
						<#if reportBusinessManage.outerManageMeasures=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.outerManageMeasures=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.outerManageRemark}</label>
					</div>
					<div class="div_item">
						<label >7、主要合作伙伴是否减少或流失：</label>
						<#if reportBusinessManage.partnerState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.partnerState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						企业的销售收入、经营利润是否能按预期目标实现：
						<#if reportBusinessManage.partnerObtainGoal=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.partnerObtainGoal=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.partnerStateRemark}</label>
					</div>
					<div class="div_item">
						<label >8、是否存在影响该笔贷款偿还的不利因素：</label>
						<#if reportBusinessManage.badEffectState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportBusinessManage.badEffectState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportBusinessManage.badEffectRemark}</label>
					</div>
					<div class="div_item">
						<label >9、其他：</label>
						${reportBusinessManage.reportBusinessManageOther}
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="12">
					三、客户品质
					<div class="div_item">
						<label >1、与客户沟通渠道是否正常：</label>
						<#if reportCumtomerQuality.communicationState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCumtomerQuality.communicationState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if> 否。
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportCumtomerQuality.communicationRemark}</label>
					</div>
					<div class="div_item">
						<label >2、客户的供货商或其他客户对授信客户产生负面评价：</label>
						<#if reportCumtomerQuality.badEvaluate=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCumtomerQuality.badEvaluate=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportCumtomerQuality.badEvaluateRemark}</label>
					</div>
					<div class="div_item">
						<label >3、是否在几个银行借款或不断在这些银行之间借新还旧：</label>
						<#if reportCumtomerQuality.loadState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCumtomerQuality.loadState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：<label style="text-align:left;width:800px;" class="label_underline" >${reportCumtomerQuality.loadStateRemark}</label>
					</div>
					<div class="div_item">
						<label >4、客户是否及时提供真实的财务、税收或抵押担保信息：</label>
						<#if reportCumtomerQuality.customerInfoState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCumtomerQuality.customerInfoState=="0" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportCumtomerQuality.customerInfoStateRemark}</label>
					</div>
					<div class="div_item">
						<label >5、还款意愿：</label>
						<#if reportCumtomerQuality.repaymentState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>良好
						<#if reportCumtomerQuality.repaymentState=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>一般
						<#if reportCumtomerQuality.repaymentState=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>较差
						<#if reportCumtomerQuality.repaymentState=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>有逃废债行为或迹象
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportCumtomerQuality.repaymentRemark}</label>
					</div>
					<div class="div_item">
						<label >6、其他：</label>
						${reportCumtomerQuality.reportCumtomerQualityOther}
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="12">
					四、客户财务情况
					<div class="div_item">
						1、在本行结算账户账号
						<label value="${reportCustomerFinancial.customerAccountInBank}" style="text-align:center;margin:0;width:320px;" class="label_underline" ></label>，检查期间现金流入
						<label style="text-align:center;margin:0;width:80px;" class="label_underline" >${reportCustomerFinancial.moneyDuringCheck}</label>万元，是否有异常变动情况：
						<#if reportCustomerFinancial.customerMoneyChangeState== "1">    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCustomerFinancial.customerMoneyChangeState== "0">    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						是否达到归行比率：
						<#if reportCustomerFinancial.customerMoneyReturnState== "1">    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if reportCustomerFinancial.customerMoneyReturnState== "0">    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否
						<br/>备注：
						<label style="text-align:left;width:800px;" class="label_underline" >${reportCustomerFinancial.customerAccountRemark}</label>
					</div>
					
					<div class="div_item">
						3、财务资料类型	
						<#if reportCustomerFinancial.customerFinanceType=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>经审计的报表
						<#if reportCustomerFinancial.customerFinanceType=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>纳税报表
						<#if reportCustomerFinancial.customerFinanceType=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>其他报表
						<#if reportCustomerFinancial.customerFinanceType=="4" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>无报表
						<br/>
						<blockquote  style="text-align:right">
							<label>单位：万元 ，%</label> <br/>
						</blockquote>
						
						<table width="100%" style="table-layout:fixed" >
							<thead style="border:1px solid #000000;">
								<tr style="border:1px solid #000000;">
									<th width="120px" style="border:1px solid #000000;">类别</th>
									<th width="160px" style="border:1px solid #000000;">项目</th>
									<th width="260px" style="border:1px solid #000000;"> 当期财务状况</th>
									<th width="260px" style="border:1px solid #000000;">上一期财务状况</th>
								</tr>
							</thead>
							<tbody style="border:1px solid #000000;">
								<tr style="border:1px solid #000000;">
									<td rowspan="3" style="border:1px solid #000000;">
										损益情况
									</td>
									<td style="border:1px solid #000000;">
									销售收入</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecSaleCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecSalePre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									利润总额</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecProfitCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecProfitPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									主要能耗</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecConsumCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceIncDecConsumPre}
									</td>
								</tr>
								
								<tr style="border:1px solid #000000;">
									<td rowspan="2" style="border:1px solid #000000;">
										资产情况
									</td>
									<td style="border:1px solid #000000;">
									应收账款</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceAssetsAccountNeedCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceAssetsAccountNeedPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									存货</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceAssetsInventoryCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceAssetsInventoryPre}
									</td>
								</tr>
								
								<tr style="border:1px solid #000000;">
									<td rowspan="3" style="border:1px solid #000000;">
										负债情况
									</td>
									<td style="border:1px solid #000000;">
									应付账款</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtAccountNeedCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtAccountNeedPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									银行借款</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtBorrowingCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtBorrowingPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									对外担保</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtGuarantyCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceDebtGuarantyPre}
									</td>
								</tr>
								
								<tr style="border:1px solid #000000;">
									<td rowspan="5" style="border:1px solid #000000;">
										比率情况
									</td>
									<td style="border:1px solid #000000;">
									资产负债率</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioAssetsLiabilitiesCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioAssetsLiabilitiesPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									流动比率</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioCurrentRatioCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioCurrentRatioPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									应收帐款周转率</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioAccountTurnroundRateCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioAccountTurnroundRatePre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									销售利润率</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioSaleProfitCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioSaleProfitPre}
									</td>
								</tr>
								<tr style="border:1px solid #000000;">
									<td style="border:1px solid #000000;">
									存货周转率</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioInventoryCur}
									</td>
									<td style="border:1px solid #000000;">
										${reportCustomerFinancial.customerFinaceRatioInventoryPre}
									</td>
								</tr>			
								
							</tbody>						
						</table>
					
					</div>
					
					<div class="div_item">
						<label >4、合同到期前财务状况预测</label>
					</div>
					
					<div class="div_item">
						（1）销售收入变化趋势：
						<#if reportCustomerFinancial.customerFinaceForecastSale=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>增加
						<#if reportCustomerFinancial.customerFinaceForecastSale=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>稳定
						<#if reportCustomerFinancial.customerFinaceForecastSale=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>减少
						<#if reportCustomerFinancial.customerFinaceForecastSale=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>恶化
						<br/>（2）利润变动趋势：
						<#if reportCustomerFinancial.customerFinaceForecastProfit=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>增加
						<#if reportCustomerFinancial.customerFinaceForecastProfit=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>稳定
						<#if reportCustomerFinancial.customerFinaceForecastProfit=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>减少
						<#if reportCustomerFinancial.customerFinaceForecastProfit=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>恶化
						<br/>（3）现金流量变动趋势：
						<#if reportCustomerFinancial.customerFinaceForecastCash=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>增加
						<#if reportCustomerFinancial.customerFinaceForecastCash=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>稳定
						<#if reportCustomerFinancial.customerFinaceForecastCash=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>减少
						<#if reportCustomerFinancial.customerFinaceForecastCash=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>恶化
						<br/>（4）经营活动现金流量变动趋势: 
						<#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>增加
						<#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>稳定
						<#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>减少
						<#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>恶化
						<br/>备注：<label id="customerFinaceForecastRemark"  name="customerFinaceForecastRemark" value="${reportCustomerFinancial.customerFinaceForecastRemark}" style="text-align:left;width:800px;" class="label_underline" ></label>
					</div>
					
					<div class="div_item">
						<label >5、影响贷款偿还的因素分析</label>
					</div>
					
					<div class="div_item">
						（1）财务风险预警信号<br/>
						<#if reportCustomerFinancial.customerEffectFinanceWaring=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>借款总额在短期内激增并与业务发展不成比例，借款人不能提供合理解释；<br/>
						<#if reportCustomerFinancial.customerEffectFinanceWaring=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>借款人股利分配与盈利状况不匹配，可能影响借款人还款能力<br/>
						<#if reportCustomerFinancial.customerEffectFinanceWaring=="3" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>借款人不能偿还其它债权人的债务
						<br/>
						（2）还本金能力：
						<#if reportCustomerFinancial.customerEffectPayMoney=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>能足额偿还本金
						<#if reportCustomerFinancial.customerEffectPayMoney=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>能部分偿还本金，预计还款金额
						<label  name="customerEffectPayMoneyAmount" id="customerEffectPayMoneyAmount" value="${reportCustomerFinancial.customerEffectPayMoneyAmount}" style="text-align:center;margin:0;width:120px;" class="label_underline" ></label>万元
						<#if reportCustomerFinancial.customerEffectPayMoney=="3" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>基本无力偿还
						<br/>
						（3）还息能力：
						<#if reportCustomerFinancial.customerEffectPayProfit=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>能足额偿还
						<#if reportCustomerFinancial.customerEffectPayProfit=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>勉强支付且无欠息
						<#if reportCustomerFinancial.customerEffectPayProfit=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>部分偿还
						<#if reportCustomerFinancial.customerEffectPayProfit=="4" >    <img src="selected_error.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>不能还息
						
					</div>
					<div class="div_item">
						<label >6、其他：</label>
						${reportCustomerFinancial.reportCustomerFinancialOther}
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="12">
					五、担保基本情况
					<div class="div_item">
						<label >担保方式：</label>
						<#if reportGuarantee.guaranteeType=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>信用
						<#if reportGuarantee.guaranteeType=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>抵（质）押
						<#if reportGuarantee.guaranteeType=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>其他
						<label style="text-align:left;margin:0;width:240px;" class="label_underline" >${reportGuarantee.guaranteeOther}</label>
					</div>
					
					<div class="div_item">
						<label>1、抵质押品资料</label><br/>
						抵（质）押品种类：<label style="text-align:center;margin:0;width:620px;" class="label_underline"  >${reportGuarantee.collateralType}</label><br/>
						抵（质）押人名称：<label style="text-align:center;margin:0;width:620px;" class="label_underline" >${reportGuarantee.collateralPerson}</label>
					</div>
					
					<div class="div_item">
						<label >2、抵（质）押品状态：</label><br/>
						<#if reportGuarantee.guaranteeState=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>正常
						<#if reportGuarantee.guaranteeState=="2" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>已被查封
						<#if reportGuarantee.guaranteeState=="3" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>已灭失
						<#if reportGuarantee.guaranteeState=="4" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>周围环境出现重大变化，严重影响抵(质)押品价值
						<#if reportGuarantee.guaranteeState=="5" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>抵质押无效
					</div>
					
					<div class="div_item">			
						3、抵（质）押品的合同价值抵质押合同中列明的抵质押品价值
						<label style="text-align:center;margin:0;width:240px;" class="label_underline" >${reportGuarantee.collateralValue}</label>万元，抵质押率
						<label style="text-align:center;margin:0;width:120px;" class="label_underline" >${reportGuarantee.collateralRate}</label>%。<br/>
						抵（质）押品目前价值
						<label style="text-align:center;margin:0;width:60px;" class="label_underline" >${reportGuarantee.collateralCurrentValue}</label>万元。
						<br/>担保情况备注
						<label style="text-align:left;width:700px;" class="label_underline" >${reportGuarantee.guaranteeRemark}</label>
					</div>
					<div class="div_item">
						<label >4、其他：</label>
						${reportGuarantee.reportGuaranteeOther}
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="12">
					检查意见与建议：
					<div >
						<label >是否发起风险预警：</label>
						<#if report.riskWarning=="1" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>是，
						<#if report.riskWarning=="0" >    <img src="selected.png" class="img_radio" /><#else><img src="unselected.png" class="img_radio" /></#if>否；
						原因：<label style="text-align:center;margin:0;width:480px;" class="label_underline" >${report.riskWarningReason}</label>
						<br/>建议采取的措施：
						<label style="text-align:center;margin:0;width:800px;" class="label_underline" >${report.proposedMeasures}</label>
						<div style="text-align:right;padding-right:200px;margin-top:20px;">
							贷后监管员签名：
							<label style="text-align:center;margin:0;width:200px;" class="label_underline" >${report.supervisor}</label>
						</div>
						<br/>业务主管意见 ：
						<label style="text-align:center;margin:0;width:200px;" class="label_underline" >${report.businessDirectorAdvice}</label>
						<div style="text-align:right;padding-right:200px;"> 
							签名：    
							<label style="text-align:center;margin:0;width:200px;" class="label_underline" >${report.businessDirector}</label>
						</div>
					</div>
				</td>
			</tr>
		</table>
		
		
	</body>

</html>