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
			table,table tr th, table tr td { border:1px solid #000000; }
			table {  min-height: 30px; line-height: 30px; text-align: center; border-collapse: collapse;}
			.input_underline{
				border:0px;border-bottom:#000000 1px solid;
			}
			.input_no_border{
				border:0px;
				outline:none;
			}
			*:focus {outline: none;} 
			.div_item{
				margin-top:5px;
			}
			
			
			input[type=radio],input[type=checkbox]  {  
				display: inline-block;  
				vertical-align: middle;  
				width: 20px;  
				height: 20px;  
				margin-left: 5px;  
				-webkit-appearance: none;  
				background-color: transparent;  
				border: 0;  
				outline: 0 !important;  
				line-height: 20px;  
				color: #d8d8d8;  
			}  
			input[type=radio]:after  {  
				content: "";  
				display:block;  
				width: 20px;  
				height: 20px;  
				border-radius: 50%;  
				text-align: center;  
				line-height: 14px;  
				font-size: 16px;  
				color: #fff;  
				border: 2px solid #ddd;  
				background-color: #fff;  
				box-sizing:border-box;  
			}  
			  
			input[type=checkbox]:after  {  
				content: "";  
				display:block;  
				width: 20px;  
				height: 20px;  
				text-align: center;  
				line-height: 14px;  
				font-size: 16px;  
				color: #fff;  
				border: 2px solid #ddd;  
				background-color: #fff;  
				box-sizing:border-box;  
			}  
			input[type=checkbox]:checked:after  {  
				border: 4px solid #ddd;  
				background-color: #37AF6E;  
			}  
			  
			input[type=radio]:checked:after  {  
				content: "L"; transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);  				-webkit-transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);  
				border-color: #37AF6E;  
				background-color: #37AF6E;  
			}
			input[disabled],input:disabled{
				background-color:#ffffff;
			}
			//IE6 Using Javascript to add CSS class "disabled"
			* html input.disabled{
				background-color:#ffffff;
			}
		</style>
	</head>

	<body style="font-family: SimSun;line-height:1">
		<div style="margin:auto auto;width:860px;">		
			

			<div>
				<h1 style="text-align:center;">中小企业贷后监管报告</h1>
			</div>
			<div style="text-align:center;" class="div_item">
				<input type="text" style="width:80px;text-align:center;" value="${report.year}" class="input_underline" maxlength='4' disabled="disabled" />
				年度第
				<input type="text" style="width:35px;text-align:center;" value="${report.reportNo}" class="input_underline" maxlength='3' disabled="disabled"/>次检查（总第
				<input type="text" style="width:35px;text-align:center;" value="${report.reportCount}" class="input_underline"  maxlength='3' disabled="disabled"/>次检查）
			</div>
			<div style="" class="div_item">
				【检查人】<input type="text" value="${report.examiner}" style="width:460px;text-align:center;" class="input_underline" disabled="disabled"/>
				【检查日期】<input type="text"  value="${report.examinTime}" style="width:200px;text-align:center;" class="input_underline" disabled="disabled"/>
			</div>
			
			<div id="step_1">
				<div style="margin-bottom:20px;margin-top:20px;">
					<label >一、客户基本情况</label>
				</div>
				
				<div class="div_item">
					<label >1、客户概况：</label>
				</div>
				
				<div class="div_item">
					<label>【客户名称】</label>
					<input type="text"  value="${customer.name}" style="text-align:center;margin:0;width:420px;" class="input_underline" disabled="disabled" />
						<label>【经营地址】</label>
					<input type="text" value="${customer.address}" style="text-align:left;margin:0;width:200px;padding-left:3px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label>【实际控制人】</label>
					<input type="text"  value="${customer.manager}" style="text-align:center;margin:0;width:405px;" class="input_underline" disabled="disabled" />
					<label>【联系电话】</label>
					<input type="text"  value="${customer.telphone}" style="text-align:left;margin:0;width:200px;padding-left:3px;" class="input_underline" disabled="disabled" />
				</div>
				<div class="div_item">
					<span style="position:relative; display:inline-block;">
						<label>【行业类型】</label>
						<input type="text"  value="${customer.industryType.name}" style="text-align:center;margin:0;width:420px;cursor:pointer;" class="input_underline" disabled="disabled" />
					</span>
					<span style="position:relative; display:inline-block;">
						<label>【主营业务】</label>
						<input type="text" value="${customer.mainBusiness}" style="text-align:left;margin:0;width:200px;padding-left:3px;" class="input_underline" disabled="disabled" />
					</span>
				</div>
				
				<div class="div_item">
					<label >【客户融资情况】</label>
				</div>
				
				<table style="margin-top:20px;width:860px;">
					<thead>
						<tr>
							<th>信贷品种</th>
							<th>合同金额</th>
							<th>当期余额</th>
							<th>贷款起始日期</th>
							<th>贷款截止日期</th>
							<th>担保措施</th>
						</tr>
					</thead>
					<tbody id='reportFinanceDetails'>
						<#list reportFinanceItems as item>
							<tr>
								<td style="width:120px;inline-height:40px;">
									<input type="text" value="${item.creditType}" class="input_no_border contractAmount" style="text-align:center;width:120px;height:40px;" disabled="disabled" />
								</td>
								<td style="width:120px;inline-height:40px;">
									<input type="text" value="${item.contractAmount}" class="input_no_border contractAmount" style="text-align:center;width:120px;height:40px;" disabled="disabled"/>
								</td>
								<td style="width:120px;inline-height:40px;">
									<input type="text" value="${item.currentBalance}" class="input_no_border currentBalance" style="text-align:center;width:120px;height:40px;" disabled="disabled"/>
								</td>
								<td style="width:120px;inline-height:40px;">
									<input type="text"  value="${item.refundStartTime}" class="input_no_border refundStartTime" placeholder="yyyy-mm-dd" style="text-align:center;width:120px;height:40px;" disabled="disabled" />
								</td>
								<td style="width:120px;inline-height:40px;">
									<input type="text" value="${item.refundEndTime}" class="input_no_border refundEndTime" placeholder="yyyy-mm-dd" style="text-align:center;width:120px;height:40px;" disabled="disabled" />
								</td>
								<td style="width:120px;inline-height:40px;">
									<input type="text" value="${item.guaranteeMeasures}" class="input_no_border guaranteeMeasures" style="text-align:center;width:120px;height:40px;" disabled="disabled"/>
								</td>
							</tr>
						</#list>
						
					</tbody>
				</table>
				
								
				<div class="div_item">
					<label >2、融资用途：</label>
				</div>
			
				<div class="div_item">
					<label> （1）批准用途：</label><br/>
					<input type="text"  value="${reportFinance.financePurpose}" style="text-align:left;margin:0 auto;min-height:50px;width:840px;font-size:14px; color:#000;margin-top:5px;line-height:25px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label> （2）实际用途：</label><br/>
					<input type="text"  value="${reportFinance.financePurposeActual}" style="text-align:left;margin:0 auto;min-height:50px;width:840px;font-size:14px; color:#000;margin-top:5px;line-height:25px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label> （3）是否按规定用途使用：</label>
					<input id="used_by_allowed_yes"  <#if reportFinance.usedByAllowed=="1" >   checked="true" </#if> value="1" type="radio"  disabled="disabled"/><label for="used_by_allowed_yes" >是，</label>
					<input id="used_by_allowed_no"  <#if reportFinance.usedByAllowed=="0" >   checked="true" </#if>  value="0"  type="radio" disabled="disabled"/><label for="used_by_allowed_no" >否</label>
				</div>
				<div class="div_item">
					<label >3、客户配套资金是否到位：</label>
					<input id="money_in_place_yes" name="moneyInPlace" <#if reportFinance.moneyInPlace=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="money_in_place_yes" >是，</label>
					<input id="money_in_place_no" name="moneyInPlace" <#if reportFinance.moneyInPlace=="0" >   checked="true" </#if>  value="0" type="radio" disabled="disabled"/><label for="money_in_place_no" >否</label>
				</div>
				<div class="div_item">
					<label >4、还款记录是否正常：</label>
					<input id="repayment_state_yes" name="financeRepaymentState" <#if reportFinance.repaymentState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/>
					<label for="repayment_state_yes" >是，</label>
					<input id="repayment_state_no" name="financeRepaymentState" <#if reportFinance.repaymentState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/>
					<label for="repayment_state_no" >否；</label>
					是否不断申请延期支付或申请实施新的授信：
					<input id="aplay_deferred_yes" name="aplayDeferred" <#if reportFinance.aplayDeferred=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/>
					<label for="aplay_deferred_yes" >是</label>
					<input id="aplay_deferred_no" name="aplayDeferred" <#if reportFinance.aplayDeferred=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/>
					<label for="aplay_deferred_no" >否；</label>
					短期债务是否超常增加：
					<input id="debt_state_yes" name="debtState" <#if reportFinance.debtState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/>
					<label for="debt_state_yes" >是</label>
					<input id="debt_state_no" name="debtState" <#if reportFinance.debtState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="debt_state_no" >否</label>
					<br/>备注：
					<input type="text" name="repaymentStateRemark" id="repaymentStateRemark" value="${reportFinance.repaymentStateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >5、其他金融机构授信金额合计：</label>
					<input type="text" value="${reportFinance.otherFinaceCreditAmount}" style="text-align:center;margin:0;width:185px;maxlength:8;" class="input_underline" disabled="disabled"/>万元，其中：贷款
					<input type="text" value="${reportFinance.otherFinaceLoan}"  style="text-align:center;margin:0;width:185px;maxlength:8;" class="input_underline" />万元，其他信贷品种及金额
					<input type="text" value="${reportFinance.otherFinaceOtherAmount}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >6、有无不良贷款或不良记录：</label>
					<input id="loan_has_bad_record_state_yes" name="loanHasBadRecordState" <#if reportFinance.loanHasBadRecordState=="1" >   checked="true" </#if> value="1" title="是" type="radio" disabled="disabled"/><label for="loan_has_bad_record_state_yes" >是</label>，金额 
					<input type="text" value="${reportFinance.loanHasBadRecordAmount}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>万元，
					<input id="loan_has_bad_record_state_no" name="loanHasBadRecordState" <#if reportFinance.loanHasBadRecordState=="0" >   checked="true" </#if> value="0" title="否" type="radio" disabled="disabled"/>否<label for="loan_has_bad_record_state_no" ></label>；
					对外担保总额
					<input type="text" value="${reportFinance.outerGuaranteeLoanAmount}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>万元，其中：保证担保
					<input type="text" value="${reportFinance.outerGuaranteeLoan}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>万元，抵质押担保
					<input type="text" value="${reportFinance.outerGuaranteeLoanMortgage}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>万元
				</div>
				<div class="div_item">
				</div>
			</div>
			
					
			<div id="step_2">
				<fieldset style="margin-top: 20px;border:0px;">
					<legend>二、客户经营管理情况</legend>
				</fieldset>
				<div class="div_item">
					<label >1、主营业务是否发生变化：</label>
					<input id="main_business_change_yes" name="mainBusinessChange" <#if reportBusinessManage.mainBusinessChange=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="main_business_change_yes" >是，</label>
					<input id="main_business_change_no" name="mainBusinessChange" <#if reportBusinessManage.mainBusinessChange=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="main_business_change_no" >否；</label>
					生产经营是否正常：
					<input id="business_state_yes" name="businessState" <#if reportBusinessManage.businessState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="business_state_yes" >是，</label>
					<input id="business_state_no" name="businessState" <#if reportBusinessManage.businessState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="business_state_no" >否；</label>
					企业发展趋势：
					<input id="enterprise_trend_1" name="enterpriseTrend" <#if reportBusinessManage.enterpriseTrend=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="enterprise_trend_1" >优</label>
					<input id="enterprise_trend_2" name="enterpriseTrend" <#if reportBusinessManage.enterpriseTrend=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="enterprise_trend_2" >良好</label>
					<input id="enterprise_trend_3" name="enterpriseTrend" <#if reportBusinessManage.enterpriseTrend=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="enterprise_trend_3" >较好</label>
					<input id="enterprise_trend_4" name="enterpriseTrend" <#if reportBusinessManage.enterpriseTrend=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="enterprise_trend_4" >一般</label>
					<input id="enterprise_trend_5" name="enterpriseTrend" <#if reportBusinessManage.enterpriseTrend=="5" >   checked="true" </#if> value="5" title="恶化" type="radio" disabled="disabled"/><label for="enterprise_trend_5" >恶化</label>
					<br/>备注：
					<input type="text" value="${reportBusinessManage.mainBusinessRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >2、管理层是否发生重大变化：</label>
					<input id="orginaltion_change_yes" name="orginaltionChange" <#if reportBusinessManage.orginaltionChange=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="orginaltion_change_yes" >是，</label>
					<input id="orginaltion_change_no" name="orginaltionChange" <#if reportBusinessManage.orginaltionChange=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="orginaltion_change_no" >否。</label>
					影响情况：
					<input id="org_change_effect_1" name="orgChangeEffect" <#if reportBusinessManage.orgChangeEffect=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="org_change_effect_1" >无影响</label>
					<input id="org_change_effect_2" name="orgChangeEffect" <#if reportBusinessManage.orgChangeEffect=="2" >   checked="true" </#if> value="2" title="有正面影响" type="radio" disabled="disabled"/><label for="org_change_effect_2" >有正面影响</label>
					<input id="org_change_effect_3" name="orgChangeEffect" <#if reportBusinessManage.orgChangeEffect=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="org_change_effect_3" >有一定负面影响，但无法判断影响程度</label>
					<input id="org_change_effect_4" name="orgChangeEffect" <#if reportBusinessManage.orgChangeEffect=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="org_change_effect_4" >将产生较大负面影响</label>
					<br/>备注：
					<input type="text" name="orgChangeRemark" id="orgChangeRemark" value="${reportBusinessManage.orgChangeRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >3、主要股东、关联公司与母子公司是否发生重大变化：</label>
					<input id="shareholders_change_yes" name="shareholdersChange" <#if reportBusinessManage.shareholdersChange=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="shareholders_change_yes" >是，</label>
					<input id="shareholders_change_no" name="shareholdersChange" <#if reportBusinessManage.shareholdersChange=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="shareholders_change_no" >否。</label>
					<br/>影响情况：
					<input id="shareholders_change_effect_1" name="shareholdersChangeEffect" <#if reportBusinessManage.shareholdersChangeEffect=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="shareholders_change_effect_1" >无影响</label>
					<input id="shareholders_change_effect_2" name="shareholdersChangeEffect" <#if reportBusinessManage.shareholdersChangeEffect=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="shareholders_change_effect_2" >有正面影响</label>
					<input id="shareholders_change_effect_3" name="shareholdersChangeEffect" <#if reportBusinessManage.shareholdersChangeEffect=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="shareholders_change_effect_3" >有一定负面影响，但无法判断影响程度</label>
					<input id="shareholders_change_effect_4" name="shareholdersChangeEffect" <#if reportBusinessManage.shareholdersChangeEffect=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="shareholders_change_effect_4" >将产生较大负面影响</label>
					<br/>备注：
					<input id="shareholdersChangeRemark" type="text" name="shareholdersChangeRemark" value="${reportBusinessManage.shareholdersChangeRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >4、客户内部管理情况：</label>
					<input id="customer_manage_1" name="customerManage" <#if reportBusinessManage.customerManage=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_manage_1" >良好</label>
					<input id="customer_manage_2" name="customerManage" <#if reportBusinessManage.customerManage=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="customer_manage_2" >一般</label>
					<input id="customer_manage_3" name="customerManage" <#if reportBusinessManage.customerManage=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="customer_manage_3" >一般</label>
					<input id="customer_manage_4" name="customerManage" <#if reportBusinessManage.customerManage=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="customer_manage_4" >有一定的问题，存在可能影响贷款偿还的因素</label>
					<input id="customer_manage_5" name="customerManage" <#if reportBusinessManage.customerManage=="5" >   checked="true" </#if> value="5" type="radio" disabled="disabled"/><label for="customer_manage_5" >管理混乱，阻碍贷款偿还</label>
					<br/>备注：
					<input id="customerManageRemark" type="text" name="customerManageRemark" value="${reportBusinessManage.customerManageRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >5、是否发生重大诉讼或仲裁、重大事故或重大赔偿：</label>
					<input id="arbitration_state_1" name="arbitrationState" <#if reportBusinessManage.arbitrationState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="arbitration_state_1" >是，</label>
					<input id="arbitration_state_2" name="arbitrationState" <#if reportBusinessManage.arbitrationState=="0" >   checked="true" </#if> value="0" title="否" type="radio" disabled="disabled"/><label for="arbitration_state_2" >否。</label>
					<br/>影响情况：
					<input id="arbitration_state_3" name="arbitrationStateEffect" <#if reportBusinessManage.arbitrationStateEffect=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="arbitration_state_3" >无影响</label>
					<input id="arbitration_state_4" name="arbitrationStateEffect" <#if reportBusinessManage.arbitrationStateEffect=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="arbitration_state_4" >有正面影响</label>
					<input id="arbitration_state_5" name="arbitrationStateEffect" <#if reportBusinessManage.arbitrationStateEffect=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="arbitration_state_5" >有一定负面影响，但无法判断影响程度</label>
					<input id="arbitration_state_6" name="arbitrationStateEffect" <#if reportBusinessManage.arbitrationStateEffect=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="arbitration_state_6" >将产生较大负面影响</label>
					<br/>备注：
					<input id="arbitrationStateRemark" type="text" name="arbitrationStateRemark" value="${reportBusinessManage.arbitrationStateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >6、外部经营环境是否发生不利经营的重大变化：</label>
					<input id="outer_manage_1" name="outerManage" <#if reportBusinessManage.outerManage=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="outer_manage_1" >是，</label>
					<input id="outer_manage_2" name="outerManage" <#if reportBusinessManage.outerManage=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="outer_manage_2" >否；</label>
					对竞争变化或外部条件变化是否有应对措施：
					<input id="outer_manage_measures_1" name="outerManageMeasures" <#if reportBusinessManage.outerManageMeasures=="1" >   checked="true" </#if> value="1"  type="radio" disabled="disabled"/><label for="outer_manage_measures_1" >是，</label>
					<input id="outer_manage_measures_2" name="outerManageMeasures" <#if reportBusinessManage.outerManageMeasures=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="outer_manage_measures_2" >否</label>
					<br/>备注：
					<input id="outerManageRemark" type="text" name="outerManageRemark" value="${reportBusinessManage.outerManageRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >7、主要合作伙伴是否减少或流失：</label>
					<input id="partner_state_1" name="partnerState" <#if reportBusinessManage.partnerState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="partner_state_1" >是，</label>
					<input id="partner_state_2" name="partnerState" <#if reportBusinessManage.partnerState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="partner_state_2" >否；</label>
					企业的销售收入、经营利润是否能按预期目标实现：
					<input id="partner_obtain_goal_1" name="partnerObtainGoal" <#if reportBusinessManage.partnerObtainGoal=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="partner_obtain_goal_1" >是，</label>
					<input id="partner_obtain_goal_2" name="partnerObtainGoal" <#if reportBusinessManage.partnerObtainGoal=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="partner_obtain_goal_2" >否</label>
					<br/>备注：
					<input id="partnerStateRemark" type="text" name="partnerStateRemark" value="${reportBusinessManage.partnerStateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >8、是否存在影响该笔贷款偿还的不利因素：</label>
					<input id="bad_effect_state_1" name="badEffectState" <#if reportBusinessManage.badEffectState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="bad_effect_state_1" >是，</label>
					<input id="bad_effect_state_2" name="badEffectState" <#if reportBusinessManage.badEffectState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="bad_effect_state_2" >否</label>
					<br/>备注：
					<input id="badEffectRemark" type="text" name="badEffectRemark" value="${reportBusinessManage.badEffectRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
			</div>
			
			<div id="step_3">
				<fieldset style="margin-top: 20px;border:0px;">
					<legend>三、客户品质</legend>
				</fieldset>
				<div class="div_item">
					<label >1、与客户沟通渠道是否正常：</label>
					<input id="communication_state_1" name="communicationState" <#if reportCumtomerQuality.communicationState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="communication_state_1" >是，</label>
					<input id="communication_state_2" name="communicationState" <#if reportCumtomerQuality.communicationState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="communication_state_2" >否。</label>
					<br/>备注：
					<input id="communicationRemark" type="text" name="communicationRemark" value="${reportCumtomerQuality.communicationRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >2、客户的供货商或其他客户对授信客户产生负面评价：</label>
					<input id="bad_evaluate_1" name="badEvaluate" <#if reportCumtomerQuality.badEvaluate=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="bad_evaluate_1" >是，</label>
					<input id="bad_evaluate_2" name="badEvaluate" <#if reportCumtomerQuality.badEvaluate=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="bad_evaluate_2" >否</label>
					<br/>备注：
					<input id="badEvaluateRemark" type="text" name="badEvaluateRemark" value="${reportCumtomerQuality.badEvaluateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >3、是否在几个银行借款或不断在这些银行之间借新还旧：</label>
					<input id="load_state_1" name="loadState" <#if reportCumtomerQuality.loadState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="load_state_1" >是，</label>
					<input id="load_state_2" name="loadState" <#if reportCumtomerQuality.loadState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="load_state_2" >否</label>
					<br/>备注：<input id="loadStateRemark" type="text" name="loadStateRemark" value="${reportCumtomerQuality.loadStateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >4、客户是否及时提供真实的财务、税收或抵押担保信息：</label>
					<input id="customer_info_state_1" name="customerInfoState" <#if reportCumtomerQuality.customerInfoState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_info_state_1" >是，</label>
					<input id="customer_info_state_2" name="customerInfoState" <#if reportCumtomerQuality.customerInfoState=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="customer_info_state_2" >否</label>
					<br/>备注：
					<input id="customerInfoStateRemark" type="text" name="customerInfoStateRemark" value="${reportCumtomerQuality.customerInfoStateRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				<div class="div_item">
					<label >5、还款意愿：</label>
					<input id="repayment_state_1" name="repaymentState" <#if reportCumtomerQuality.repaymentState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="repayment_state_1" >良好</label>
					<input id="repayment_state_2" name="repaymentState" <#if reportCumtomerQuality.repaymentState=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="repayment_state_2" >一般</label>
					<input id="repayment_state_3" name="repaymentState" <#if reportCumtomerQuality.repaymentState=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="repayment_state_3" >较差</label>
					<input id="repayment_state_4" name="repaymentState" <#if reportCumtomerQuality.repaymentState=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="repayment_state_4" >有逃废债行为或迹象</label>
					<br/>备注：
					<input id="repaymentRemark" type="text" name="repaymentRemark" value="${reportCumtomerQuality.repaymentRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
			</div>
			
			<div id="step_4">
				<fieldset style="margin-top: 20px;border:0px;">
					<legend>四、客户财务情况</legend>
				</fieldset>
				<div class="div_item">
					1、在本行结算账户账号
					<input id="customerAccountInBank" type="text" name="customerAccountInBank" value="${reportCustomerFinancial.customerAccountInBank}" style="text-align:center;margin:0;width:320px;" class="input_underline" disabled="disabled"/>，检查期间现金流入
					<input id="moneyDuringCheck" type="text" name="moneyDuringCheck" value="${reportCustomerFinancial.moneyDuringCheck}" style="text-align:center;margin:0;width:80px;" class="input_underline" disabled="disabled"/>万元，是否有异常变动情况：
					<input id="customer_money_change_state_1" name="customerMoneyChangeState" <#if reportCustomerFinancial.customerMoneyChangeState== "1">   checked="true" </#if> value="1" type="radio" disabled="disabled" /><label for="customer_money_change_state_1" >是，</label>
					<input id="customer_money_change_state_2" name="customerMoneyChangeState" <#if reportCustomerFinancial.customerMoneyChangeState== "0">   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="customer_money_change_state_2" >否；</label>
					是否达到归行比率：
					<input id="customer_money_return_state_1" name="customerMoneyReturnState" <#if reportCustomerFinancial.customerMoneyReturnState== "1">   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_money_return_state_1" >是，</label>
					<input id="customer_money_return_state_2" name="customerMoneyReturnState" <#if reportCustomerFinancial.customerMoneyReturnState== "0">   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="customer_money_return_state_2" >否</label>
					<br/>备注：
					<input id="customerAccountRemark" type="text" name="customerAccountRemark" value="${reportCustomerFinancial.customerAccountRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				
				<div class="div_item">
					3、财务资料类型	
					<input id="customer_finance_type_1" name="customerFinanceType" <#if reportCustomerFinancial.customerFinanceType=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_finance_type_1" >经审计的报表</label>
					<input id="customer_finance_type_2" name="customerFinanceType" <#if reportCustomerFinancial.customerFinanceType=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="customer_finance_type_2" >纳税报表</label>
					<input id="customer_finance_type_3" name="customerFinanceType" <#if reportCustomerFinancial.customerFinanceType=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="customer_finance_type_3" >其他报表</label>
					<input id="customer_finance_type_4" name="customerFinanceType" <#if reportCustomerFinancial.customerFinanceType=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="customer_finance_type_4" >无报表</label>
					<br/>
					<blockquote  style="text-align:right">
						<label>单位：万元 ，%</label> <br/>
					</blockquote>
					
					<table>
						<thead>
							<tr>
								<th width="120px">类别</th>
								<th width="160px">项目</th>
								<th width="260px"> 当期财务状况</th>
								<th width="260px">上一期财务状况</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td rowspan="3">
									损益情况
								</td>
								<td>
								销售收入</td>
								<td>
									<input id="customerFinaceIncDecSaleCur" type="text" name="customerFinaceIncDecSaleCur" value="${reportCustomerFinancial.customerFinaceIncDecSaleCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceIncDecSalePre" type="text" name="customerFinaceIncDecSalePre" value="${reportCustomerFinancial.customerFinaceIncDecSalePre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								利润总额</td>
								<td>
									<input id="customerFinaceIncDecProfitCur" type="text" name="customerFinaceIncDecProfitCur" value="${reportCustomerFinancial.customerFinaceIncDecProfitCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceIncDecProfitPre" type="text" name="customerFinaceIncDecProfitPre" value="${reportCustomerFinancial.customerFinaceIncDecProfitPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								主要能耗</td>
								<td>
									<input id="customerFinaceIncDecConsumCur" type="text" name="customerFinaceIncDecConsumCur" value="${reportCustomerFinancial.customerFinaceIncDecConsumCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceIncDecConsumPre" type="text" name="customerFinaceIncDecConsumPre" value="${reportCustomerFinancial.customerFinaceIncDecConsumPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							
							<tr>
								<td rowspan="2">
									资产情况
								</td>
								<td>
								应收账款</td>
								<td>
									<input id="customerFinaceAssetsAccountNeedCur" type="text" name="customerFinaceAssetsAccountNeedCur" value="${reportCustomerFinancial.customerFinaceAssetsAccountNeedCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceAssetsAccountNeedPre" type="text" name="customerFinaceAssetsAccountNeedPre" value="${reportCustomerFinancial.customerFinaceAssetsAccountNeedPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								存货</td>
								<td>
									<input id="customerFinaceAssetsInventoryCur" type="text" name="customerFinaceAssetsInventoryCur" value="${reportCustomerFinancial.customerFinaceAssetsInventoryCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceAssetsInventoryPre" type="text" name="customerFinaceAssetsInventoryPre" value="${reportCustomerFinancial.customerFinaceAssetsInventoryPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							
							<tr>
								<td rowspan="3">
									负债情况
								</td>
								<td>
								应付账款</td>
								<td>
									<input id="customerFinaceDebtAccountNeedCur" type="text" name="customerFinaceDebtAccountNeedCur" value="${reportCustomerFinancial.customerFinaceDebtAccountNeedCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceDebtAccountNeedPre"  type="text" name="customerFinaceDebtAccountNeedPre" value="${reportCustomerFinancial.customerFinaceDebtAccountNeedPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								银行借款</td>
								<td>
									<input id="customerFinaceDebtBorrowingCur" type="text" name="customerFinaceDebtBorrowingCur" style="text-align:center;margin:0;" value="${reportCustomerFinancial.customerFinaceDebtBorrowingCur}" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceDebtBorrowingPre" type="text" name="customerFinaceDebtBorrowingPre" style="text-align:center;margin:0;" value="${reportCustomerFinancial.customerFinaceDebtBorrowingPre}" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								对外担保</td>
								<td>
									<input id="customerFinaceDebtGuarantyCur" type="text" name="customerFinaceDebtGuarantyCur" style="text-align:center;margin:0;" value="${reportCustomerFinancial.customerFinaceDebtGuarantyCur}" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceDebtGuarantyPre" type="text" name="customerFinaceDebtGuarantyPre" style="text-align:center;margin:0;" value="${reportCustomerFinancial.customerFinaceDebtGuarantyPre}" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							
							<tr>
								<td rowspan="5">
									比率情况
								</td>
								<td>
								资产负债率</td>
								<td>
									<input id="customerFinaceRatioAssetsLiabilitiesCur" type="text" name="customerFinaceRatioAssetsLiabilitiesCur" value="${reportCustomerFinancial.customerFinaceRatioAssetsLiabilitiesCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceRatioAssetsLiabilitiesPre" type="text" name="customerFinaceRatioAssetsLiabilitiesPre" value="${reportCustomerFinancial.customerFinaceRatioAssetsLiabilitiesPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								流动比率</td>
								<td>
									<input id="customerFinaceRatioCurrentRatioCur" type="text" name="customerFinaceRatioCurrentRatioCur" value="${reportCustomerFinancial.customerFinaceRatioCurrentRatioCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceRatioCurrentRatioPre" type="text" name="customerFinaceRatioCurrentRatioPre" value="${reportCustomerFinancial.customerFinaceRatioCurrentRatioPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								应收帐款周转率</td>
								<td>
									<input id="customerFinaceRatioAccountTurnroundRateCur" type="text" name="customerFinaceRatioAccountTurnroundRateCur" value="${reportCustomerFinancial.customerFinaceRatioAccountTurnroundRateCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceRatioAccountTurnroundRatePre" type="text" name="customerFinaceRatioAccountTurnroundRatePre" value="${reportCustomerFinancial.customerFinaceRatioAccountTurnroundRatePre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								销售利润率</td>
								<td>
									<input id="customerFinaceRatioSaleProfitCur" type="text" name="customerFinaceRatioSaleProfitCur" value="${reportCustomerFinancial.customerFinaceRatioSaleProfitCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceRatioSaleProfitPre" type="text" name="customerFinaceRatioSaleProfitPre" value="${reportCustomerFinancial.customerFinaceRatioSaleProfitPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>
								存货周转率</td>
								<td>
									<input id="customerFinaceRatioInventoryCur" type="text" name="customerFinaceRatioInventoryCur" value="${reportCustomerFinancial.customerFinaceRatioInventoryCur}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
								</td>
								<td>
									<input id="customerFinaceRatioInventoryPre" type="text" name="customerFinaceRatioInventoryPre" value="${reportCustomerFinancial.customerFinaceRatioInventoryPre}" style="text-align:center;margin:0;" class="input_no_border" disabled="disabled"/>
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
					<input id="customer_finace_forecast_sale_1" name="customerFinaceForecastSale" <#if reportCustomerFinancial.customerFinaceForecastSale=="1" >   checked="true" </#if> value="1"  type="radio" disabled="disabled"/><label for="customer_finace_forecast_sale_1" >增加</label>
					<input id="customer_finace_forecast_sale_2" name="customerFinaceForecastSale" <#if reportCustomerFinancial.customerFinaceForecastSale=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="customer_finace_forecast_sale_2" >稳定</label>
					<input id="customer_finace_forecast_sale_3" name="customerFinaceForecastSale" <#if reportCustomerFinancial.customerFinaceForecastSale=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="customer_finace_forecast_sale_3" >减少</label>
					<input id="customer_finace_forecast_sale_4" name="customerFinaceForecastSale" <#if reportCustomerFinancial.customerFinaceForecastSale=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="customer_finace_forecast_sale_4" >恶化</label>
					<br/>（2）利润变动趋势：
					<input id="customer_finace_forecast_profit_1" name="customerFinaceForecastProfit" <#if reportCustomerFinancial.customerFinaceForecastProfit=="1" >   checked="true" </#if> value="1" type="radio" style="margin-left:36px;" disabled="disabled"/><label for="customer_finace_forecast_profit_1" >增加</label>
					<input id="customer_finace_forecast_profit_2" name="customerFinaceForecastProfit" <#if reportCustomerFinancial.customerFinaceForecastProfit=="2" >   checked="true" </#if> value="2" type="radio"   disabled="disabled"/><label for="customer_finace_forecast_profit_2" >稳定</label>
					<input id="customer_finace_forecast_profit_3" name="customerFinaceForecastProfit" <#if reportCustomerFinancial.customerFinaceForecastProfit=="3" >   checked="true" </#if> value="3" type="radio"   disabled="disabled"/><label for="customer_finace_forecast_profit_3" >减少</label>
					<input id="customer_finace_forecast_profit_4" name="customerFinaceForecastProfit" <#if reportCustomerFinancial.customerFinaceForecastProfit=="4" >   checked="true" </#if> value="4" type="radio"   disabled="disabled"/><label for="customer_finace_forecast_profit_4" >恶化</label>
					<br/>（3）现金流量变动趋势：
					<input id="customer_finace_forecast_cash_1" name="customerFinaceForecastCash" <#if reportCustomerFinancial.customerFinaceForecastCash=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_finace_forecast_cash_1" >增加</label>
					<input id="customer_finace_forecast_cash_2" name="customerFinaceForecastCash" <#if reportCustomerFinancial.customerFinaceForecastCash=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="customer_finace_forecast_cash_2" >稳定</label>
					<input id="customer_finace_forecast_cash_3" name="customerFinaceForecastCash" <#if reportCustomerFinancial.customerFinaceForecastCash=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="customer_finace_forecast_cash_3" >减少</label>
					<input id="customer_finace_forecast_cash_4" name="customerFinaceForecastCash" <#if reportCustomerFinancial.customerFinaceForecastCash=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="customer_finace_forecast_cash_4" >恶化</label>
					<br/>（4）经营活动现金流量变动趋势: 
					<input id="customer_finace_forecast_business_cash_1" name="customerFinaceForecastBusinessCash" <#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_finace_forecast_business_cash_1" >增加</label>
					<input id="customer_finace_forecast_business_cash_2" name="customerFinaceForecastBusinessCash" <#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="customer_finace_forecast_business_cash_2" >稳定</label>
					<input id="customer_finace_forecast_business_cash_3" name="customerFinaceForecastBusinessCash" <#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="customer_finace_forecast_business_cash_3" >减少</label>
					<input id="customer_finace_forecast_business_cash_4" name="customerFinaceForecastBusinessCash" <#if reportCustomerFinancial.customerFinaceForecastBusinessCash=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="customer_finace_forecast_business_cash_4" >恶化</label>
					<br/>备注：<input id="customerFinaceForecastRemark" type="text" name="customerFinaceForecastRemark" value="${reportCustomerFinancial.customerFinaceForecastRemark}" style="text-align:left;width:800px;" class="input_underline" disabled="disabled"/>
				</div>
				
				<div class="div_item">
					<label >5、影响贷款偿还的因素分析</label>
				</div>
				
				<div class="div_item">
					（1）财务风险预警信号<br/>
					<input id="customer_effect_finance_waring_1" name="customerEffectFinanceWaring" <#if reportCustomerFinancial.customerEffectFinanceWaring=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="customer_effect_finance_waring_1" >借款总额在短期内激增并与业务发展不成比例，借款人不能提供合理解释；</label><br/>
					<input id="customer_effect_finance_waring_2" name="customerEffectFinanceWaring" <#if reportCustomerFinancial.customerEffectFinanceWaring=="2" >   checked="true" </#if> value="2"  type="radio"  disabled="disabled"/><label for="customer_effect_finance_waring_2" >借款人股利分配与盈利状况不匹配，可能影响借款人还款能力</label><br/>
					<input id="customer_effect_finance_waring_3" name="customerEffectFinanceWaring" <#if reportCustomerFinancial.customerEffectFinanceWaring=="3" >   checked="true" </#if> value="3"  type="radio"   disabled="disabled"/><label for="customer_effect_finance_waring_3" >借款人不能偿还其它债权人的债务</label>
					<br/>
					（2）还本金能力：
					<input id="customer_effect_pay_money_1" name="customerEffectPayMoney" <#if reportCustomerFinancial.customerEffectPayMoney=="1" >   checked="true" </#if> value="1"  type="radio" disabled="disabled"/><label for="customer_effect_pay_money_1" >能足额偿还本金</label>
					<input id="customer_effect_pay_money_2" name="customerEffectPayMoney" <#if reportCustomerFinancial.customerEffectPayMoney=="2" >   checked="true" </#if> value="2"  type="radio" disabled="disabled"/><label for="customer_effect_pay_money_2" >能部分偿还本金，预计还款金额</label>
					<input type="text" name="customerEffectPayMoneyAmount" id="customerEffectPayMoneyAmount" value="${reportCustomerFinancial.customerEffectPayMoneyAmount}" style="text-align:center;margin:0;width:120px;" class="input_underline" disabled="disabled"/>万元
					<input id="customer_effect_pay_money_3" name="customerEffectPayMoney" <#if reportCustomerFinancial.customerEffectPayMoney=="3" >   checked="true" </#if> value="3"  type="radio" disabled="disabled"/><label for="customer_effect_pay_money_3" >基本无力偿还</label>
					<br/>
					（3）还息能力：
					<input id="customer_effect_pay_profit_1" name="customerEffectPayProfit" <#if reportCustomerFinancial.customerEffectPayProfit=="1" >   checked="true" </#if> value="1"  type="radio" disabled="disabled"/><label for="customer_effect_pay_profit_1" >能足额偿还</label>
					<input id="customer_effect_pay_profit_2" name="customerEffectPayProfit" <#if reportCustomerFinancial.customerEffectPayProfit=="2" >   checked="true" </#if> value="2"  type="radio" disabled="disabled"/><label for="customer_effect_pay_profit_2" >勉强支付且无欠息</label>
					<input id="customer_effect_pay_profit_3" name="customerEffectPayProfit" <#if reportCustomerFinancial.customerEffectPayProfit=="3" >   checked="true" </#if> value="3"  type="radio" disabled="disabled"/><label for="customer_effect_pay_profit_3" >部分偿还</label>
					<input id="customer_effect_pay_profit_4" name="customerEffectPayProfit" <#if reportCustomerFinancial.customerEffectPayProfit=="4" >   checked="true" </#if> value="4"  type="radio" disabled="disabled"/><label for="customer_effect_pay_profit_4" >不能还息</label>
					
				</div>
			</div>
			
			<div id="step_5">
				<fieldset style="margin-top: 20px;border:0px;">
					<legend>五、担保基本情况</legend>
				</fieldset>
				
				<div class="div_item">
					<label >担保方式：</label>
					<input id="guarantee_type_1" name="guaranteeType" <#if reportGuarantee.guaranteeType=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="guarantee_type_1" >信用</label>
					<input id="guarantee_type_2" name="guaranteeType" <#if reportGuarantee.guaranteeType=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="guarantee_type_2" >抵（质）押</label>
					<input id="guarantee_type_3" name="guaranteeType" <#if reportGuarantee.guaranteeType=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="guarantee_type_3" >其他</label>
					<input id="guaranteeOther" type="text" name="guaranteeOther" value="${reportGuarantee.guaranteeOther}" style="text-align:left;margin:0;width:240px;" class="input_underline" disabled="disabled"/>
				</div>
				
				<div class="div_item">
					<label>1、抵质押品资料</label><br/>
					抵（质）押品种类：<input id="collateralType" type="text" name="collateralType" value="${reportGuarantee.collateralType}" style="text-align:center;margin:0;width:620px;" class="input_underline"  disabled="disabled"/><br/>
					抵（质）押人名称：<input id="collateralPerson" type="text" name="collateralPerson" value="${reportGuarantee.collateralPerson}" style="text-align:center;margin:0;width:620px;" class="input_underline" disabled="disabled"/>
				</div>
				
				<div class="div_item">
					<label >2、抵（质）押品状态：</label><br/>
					<input id="guarantee_state_1" name="guaranteeState" <#if reportGuarantee.guaranteeState=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="guarantee_state_1" >正常</label>
					<input id="guarantee_state_2" name="guaranteeState" <#if reportGuarantee.guaranteeState=="2" >   checked="true" </#if> value="2" type="radio" disabled="disabled"/><label for="guarantee_state_2" >已被查封</label>
					<input id="guarantee_state_3" name="guaranteeState" <#if reportGuarantee.guaranteeState=="3" >   checked="true" </#if> value="3" type="radio" disabled="disabled"/><label for="guarantee_state_3" >已灭失</label>
					<input id="guarantee_state_4" name="guaranteeState" <#if reportGuarantee.guaranteeState=="4" >   checked="true" </#if> value="4" type="radio" disabled="disabled"/><label for="guarantee_state_4" >周围环境出现重大变化，严重影响抵(质)押品价值</label>
					<input id="guarantee_state_5" name="guaranteeState" <#if reportGuarantee.guaranteeState=="5" >   checked="true" </#if> value="5" type="radio" disabled="disabled"/><label for="guarantee_state_5" >抵质押无效</label>
				</div>
				
				<div class="div_item">			
					3、抵（质）押品的合同价值抵质押合同中列明的抵质押品价值
					<input id="collateralValue" type="text" name="collateralValue" value="${reportGuarantee.collateralValue}" style="text-align:center;margin:0;width:240px;" class="input_underline" disabled="disabled"/>万元，抵质押率
					<input id="collateralRate" type="text" name="collateralRate" value="${reportGuarantee.collateralRate}" style="text-align:center;margin:0;width:120px;" class="input_underline" disabled="disabled"/>%。<br/>
					抵（质）押品目前价值
					<input id="collateralCurrentValue" type="text" name="collateralCurrentValue" value="${reportGuarantee.collateralCurrentValue}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>万元。
					<br/>担保情况备注
					<input id="guaranteeRemark" type="text" name="guaranteeRemark" value="${reportGuarantee.guaranteeRemark}" style="text-align:left;width:700px;" class="input_underline" disabled="disabled"/>
				</div>
			</div>
			
			<div id="step_6">
				<div class="div_item">			
				检查意见与建议：
				</div>
				<div >
					<label >是否发起风险预警：</label>
					<input id="risk_warning_1" name="risk_warning" <#if report.riskWarning=="1" >   checked="true" </#if> value="1" type="radio" disabled="disabled"/><label for="risk_warning_1" >是，</label>
					<input id="risk_warning_2" name="risk_warning" <#if report.riskWarning=="0" >   checked="true" </#if> value="0" type="radio" disabled="disabled"/><label for="risk_warning_2" >否；</label>
					原因：<input id="risk_warning_reason" value="${report.riskWarningReason}" type="text" name="risk_warning_reason" style="text-align:center;margin:0;width:480px;" class="input_underline" disabled="disabled"/>
					<br/>建议采取的措施：
					<input id="proposed_measures" type="text" value="${report.proposedMeasures}" name="proposed_measures" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>
					<div style="text-align:right;width:860px;padding-right:200px;">
						贷后监管员签名：
						<input id="supervisor" type="text" name="supervisor" value="${report.supervisor}" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>
					</div>
					<br/>业务主管意见 ：
					<input id="business_director_advice" value="${report.businessDirectorAdvice}" type="text" name="business_director_advice" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>
					<div style="text-align:right;width:860px;padding-right:200px;"> 
						签名：    
						<input id="business_director" type="text" value="${report.businessDirector}" name="business_director" style="text-align:center;margin:0;" class="input_underline" disabled="disabled"/>
					</div>
				</div>
			</div>
			
		</div>
		
	</body>

</html>