<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="zh-Hant">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>CasePage</title>
<link rel="stylesheet" href="../resources/css/nicepage.css" media="screen">
<link rel="stylesheet" href="../resources/css/CasePage.css" media="screen">
<script class="u-script" type="text/javascript"
	src="../resources/js/jquery.js" defer=""></script>
<script class="u-script" type="text/javascript"
	src="../resources/js/nicepage.js" defer=""></script>
<meta name="generator" content="Nicepage 3.23.2, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">

<script src="https://www.itxst.com/package/jquery-3.5.1/jquery.min.js"></script>

<script
	src="https://www.itxst.com/package/bootstrap-datepicker-1.9.0/js/bootstrap-datepicker.min.js"></script>
<script
	src="https://www.itxst.com/package/bootstrap-datepicker-1.9.0/locales/bootstrap-datepicker.zh-CN.min.js">
	
</script>
<link
	href="https://www.itxst.com/package/bootstrap-datepicker-1.9.0/css/bootstrap-datepicker.min.css"
	rel="stylesheet">

<script type="application/ld+json">
    {
      "@context": "http://schema.org",
      "@type": "Organization",
      "name": "TestDemo",
      "logo": "images/LOGO-TEST-22.png"
    }
</script>

<style type="text/css">
   		.fix-padding {
    		padding: 10px 46px;
    	}
    	.u-header .u-group-2 {
    		width: 390px;
    	}
</style>

<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="CasePage">
<meta property="og:description" content="">
<meta property="og:type" content="website">
</head>
<body class="u-body">
	<header class="u-clearfix u-header u-header" id="sec-4c0b">
		<div class="u-clearfix u-sheet u-sheet-1">
			<a href="2143501032" class="u-image u-logo u-image-1" title="網站首頁"
				data-image-width="570" data-image-height="410"> <img
				src="../resources/images/LOGO-TEST-22.png"
				class="u-logo-image u-logo-image-1">
			</a>
			<nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
				<div class="menu-collapse"
					style="font-size: 1.125rem; letter-spacing: 0px;">
					<a
						class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
						href="#"> <svg>
							<use xmlns:xlink="http://www.w3.org/1999/xlink"
								xlink:href="#menu-hamburger"></use></svg> <svg version="1.1"
							xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<defs>
							<symbol id="menu-hamburger" viewBox="0 0 16 16"
								style="width: 16px; height: 16px;">
							<rect y="1" width="16" height="2"></rect>
							<rect y="7" width="16" height="2"></rect>
							<rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
					</a>
				</div>
				<div class="u-custom-menu u-nav-container">
					<ul class="u-nav u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base"
							href="<%= request.getContextPath() %>/painterlist" style="padding: 10px 20px;">畫師列表</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base"
							href="<%= request.getContextPath() %>/caselistpage.controller" style="padding: 10px 20px;">案件列表</a></li>
						
					</ul>
				</div>
				<div class="u-custom-menu u-nav-container-collapse">
					<div
						class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
						<div class="u-sidenav-overflow">
							<div class="u-menu-close"></div>
							<ul
								class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="javascript::" style="padding: 10px 20px;">畫師列表</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									style="padding: 10px 20px;">案件列表</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									style="padding: 10px 20px;">公開畫廊</a></li>
							</ul>
						</div>
					</div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</nav>
			<div class="u-container-style u-group u-white u-group-1">
				
			</div>
			<div class="u-container-style u-group u-white u-group-2">
				<div class="u-container-layout u-container-layout-2">
					<div>
	                        <a href="<%= request.getContextPath() %>/CaseFormApplyPage/<%=request.getAttribute("member_id")%>"
	                            class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-3" name="issue_case" style="display:none">發布案件</a>
	                        <a href="<%= request.getContextPath() %>/backend/accountmanager"
	                            class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-4 fix-margin" name="account_manager" style="display:none">帳號管理</a>
                        	<span class="u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-4" name="member_name" style="display:none"><%= request.getAttribute("member_name") %></span>
                        </div>
                        <div>
	                        <a href="/PaintPartyMvcProject/login"
	                            class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-3" name="header_login" style="display:none">登入</a>
	                        <a href="/PaintPartyMvcProject/register"
	                            class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-4 fix-margin" name="header_register" style="display:none">註冊</a>
                    	</div>
                    </div>
                    <div>
                    	<a class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-5 fix-padding" name="logout" onclick="logout()">登出</a>
                    </div>
				</div>
			</div>
		</div>
	</header>
	<section class="u-align-left u-clearfix u-grey-10 u-section-1"
		id="sec-2ace">
		<div class="u-clearfix u-sheet u-sheet-1">
			<div class="u-clearfix u-layout-wrap u-layout-wrap-1">
				<div class="u-layout">
					<div class="u-layout-row">
						<div
							class="u-container-style u-layout-cell u-size-18 u-layout-cell-1">
							<div class="u-container-layout u-container-layout-1">
								<div
									class="u-container-style u-group  u-shape-round u-white u-group-1">
									<div class="u-container-layout u-container-layout-2">
										<div class="u-align-left u-container-style u-group u-group-2" style="min-height:auto;">
											<div class="u-container-layout u-container-layout-2">
												
												<div class="">
													<a href="<%= request.getContextPath() %>/memberpage/${memId}"><img src="<%= request.getContextPath() %>/casepagedisplaymemId" class="rounded-3 border border-2 mx-auto d-block" style="display: block;max-width: 100%;height: 120px;"></a>
												</div>
											</div>
										</div>
										<h3 class="u-align-center" style="margin-top:20px;color: #4a4a4a;">${caseOwner}</h3>
									</div>
								</div>
								<div
									class="u-container-style u-group u-shape-round u-white u-group-4">
									<div
										class="u-container-layout u-valign-top u-container-layout-5">
										<div
											class="u-border-1 u-border-white u-container-style u-expanded-width u-group u-radius-10 u-shape-round u-group-5">
											<div class="u-container-layout u-container-layout-6">

												<div class="form-row d-flex">
													<div class="form-group col-md-12 p-2">
														<label for="inputLowBudget" style="color:#4a4a4a;">單張稿酬預算</label><br />
														<div class="" style="color: burlywood; font-size: 30px">$
															${lowBudget} ~ ${highBudget}</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="u-border-1 u-border-white u-container-style u-expanded-width u-group u-radius-20 u-shape-round u-group-6">
											<div class="u-container-layout u-container-layout-8">
												<p class="u-text u-text-default u-text-7" style="color:#4a4a4a;">上架日期：</p>
												<div class="u-container-style u-group u-group-8">
													<h3 style="color: burlywood; font-size: 30px">${uploadDate}</h3>
												</div>
											</div>
										</div>
										<div
											class="u-border-2 u-border-white u-container-style u-radius-20 u-shape-round ">
											<div class="form-group col-md-6 p-2">
												<label for="inputLowBudget" style="color:#4a4a4a;">畫作風格：</label><br /><div class="" style="color: burlywood; font-size: 25px">
															${style}</div><br /> 
											</div>
											<div class="form-group col-md-6 p-2">
												<label for="inputLowBudget" style="color:#4a4a4a;">創作類型：</label><br /><div class="" style="color: burlywood; font-size: 25px">
															${type}</div><br /> 
											</div>
										</div>
									</div>
								</div>
								
								 
								<a href="<%= request.getContextPath() %>/caseapplymainpage.controller/${caseid}"
									class="u-border-none u-btn u-btn-round u-button-style u-hover-palette-1-light-1 u-palette-1-base u-radius-10 u-btn-1" name="applyCase" style="display:none" >應徵此案件</a>
							</div>
						</div>
						<div
							class="u-container-style u-layout-cell u-shape-rectangle u-size-42 u-layout-cell-2">
							<div class="u-container-layout u-container-layout-15">
								<div
									class="u-container-style u-group u-radius-20 u-shape-round u-white u-group-14">
									<div class="u-container-layout u-container-layout-16">
										<div class="form-group u-container-layout">
											<p style="font-size: 50px; font-weight: bold;">${caseTitle}</p>
										</div>
										<div class="form-group u-container-layout">
											<div style="color: darkblue; font-weight: bold; font-size: 30px;">描述需求</div>
											<br />
											<section class="input-group">
												<div>${demand }</div>
											</section>
										</div>
										<div>
											<p style="color: darkblue; font-weight: bold; font-size: 30px;">參考圖例</p>
											<div
												class="u-container-layout u-container-layout-21 ">
												<div class="container"  
													><img src="<%= request.getContextPath() %>/casepagedisplayexImg" class="img-thumbnail img-polaroid" style="display: block;max-width: 100%;height: 300px;"/></div> 
												<!-- data-image-width="1500" data-image-height="1000"<div class="u-container-style u-group u-group-20">
													<div class="u-container-layout u-container-layout-22"></div>
												</div>
												 <p class="u-text u-text-default u-text-19">畫師暱稱</p>-->
											</div>
										</div>
									</div>
								</div>


								<div
									class="u-container-style u-group u-radius-20 u-shape-round u-white "
									style="margin-top: 20px;">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<footer class="u-align-center u-clearfix u-footer u-grey-70 u-footer"
		id="sec-c7c8">
		<p class="u-small-text u-text u-text-variant u-text-1">Copyright @
			dodo 2021</p>
		<nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
			<div class="menu-collapse"
				style="font-size: 1rem; letter-spacing: 0px;">
				<a
					class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
					href="#"> <svg>
						<use xmlns:xlink="http://www.w3.org/1999/xlink"
							xlink:href="#menu-hamburger"></use></svg> <svg version="1.1"
						xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink">
						<defs>
						<symbol id="menu-hamburger" viewBox="0 0 16 16"
							style="width: 16px; height: 16px;">
						<rect y="1" width="16" height="2"></rect>
						<rect y="7" width="16" height="2"></rect>
						<rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
				</a>
			</div>
			<div class="u-custom-menu u-nav-container">
				<ul class="u-nav u-unstyled u-nav-1">
					<li class="u-nav-item"><a
						class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base"
						style="padding: 10px 96px;">聯絡我們</a></li>
					<li class="u-nav-item"><a
						class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base"
						style="padding: 10px 96px;">常見問題</a></li>
				</ul>
			</div>
			<div class="u-custom-menu u-nav-container-collapse">
				<div
					class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
					<div class="u-sidenav-overflow">
						<div class="u-menu-close"></div>
						<ul
							class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								style="padding: 10px 96px;">聯絡我們</a></li>
							<li class="u-nav-item"><a class="u-button-style u-nav-link"
								style="padding: 10px 96px;">常見問題</a></li>
						</ul>
					</div>
				</div>
				<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
			</div>
		</nav>
	</footer>
	<script type="text/javascript">
    //登入狀態與登出狀態功能列表
    //透過AllFilter 傳過來的session
//     <h1>${sessionScope.login}</h1>
   
    if(${sessionScope.login}==1){ //代表有登入狀態
    	$("[name=issue_case]").show()
    	$("[name=account_manager]").show()
    	$("[name=member_name]").show()
  
    	
    }else{
    	$("[name=header_login]").show()
    	$("[name=header_register]").show()
    	
    }
    
    
    
    var s = '畫師';
    var a = '${attr}';
    var whoOwnThisCase = '${memId}';
    var whoLogin = '${member_id}';
	var whoApply = '${whoApply}';

    
    
    if(a==s && whoOwnThisCase != whoLogin ){//判斷身分=畫師
    	if(whoLogin != whoApply){
    			$("[name=applyCase]").show()
    	}
    }
    //登出
    function logout(){
    	
    	window.location.href = '/PaintPartyMvcProject/logout'
    }
    
   
    
	</script>
</body>
</html>