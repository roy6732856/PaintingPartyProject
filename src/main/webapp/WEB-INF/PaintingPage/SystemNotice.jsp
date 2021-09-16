<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	
 
<!DOCTYPE html>
<html style="font-size: 16px;" lang="zh-Hant">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>SystemNotice</title>
    
    <script class="u-script" type="text/javascript" src="../resources/js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="../resources/js/nicepage.js" defer=""></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>
    
    <link rel="stylesheet" href="../resources/css/nicepage.css" media="screen">
    <link rel="stylesheet" href="../resources/css/SystemNotice.css" media="screen">

    <meta name="generator" content="Nicepage 3.23.2, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">


<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "框架final project",
		"logo": "images/LOGO-TEST-22.png"
}</script>


<!-- <script type="text/javascript">
	$(function() {
		$.ajax({
			url : "/PaintPartyMvcProject/backend/systemnotice",
			type : 'post',
			dataType : 'json',
			data : {

			},
			success : function(sus) {
 				for (var i = 0; i < data.length; i++) {

 				}
			},
			error : function(err) {
				console.log(err)
			},
		})
	});
</script> -->





<meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="SystemNotice">
    <meta property="og:description" content="">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body"><header class="u-clearfix u-header u-header" id="sec-4c0b"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="2143501032" class="u-image u-logo u-image-1" title="網站首頁" data-image-width="570" data-image-height="410">
          <img src="../resources/images/LOGO-TEST-22.png" class="u-logo-image u-logo-image-1">
        </a>
        <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse" style="font-size: 1.125rem; letter-spacing: 0px;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
              <svg><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
              <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
            </a>
          </div>
          <div class="u-custom-menu u-nav-container">
            <ul class="u-nav u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base" href="javascript::" style="padding: 10px 20px;">畫師列表</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base" href="<%= request.getContextPath() %>/caselistpage.controller" style="padding: 10px 20px;">案件列表</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base" style="padding: 10px 20px;">公開畫廊</a>
</li></ul>
          </div>
          <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="javascript::" style="padding: 10px 20px;">畫師列表</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" style="padding: 10px 20px;">案件列表</a>
</li><li class="u-nav-item">
<a class="u-button-style u-nav-link" style="padding: 10px 20px;">公開畫廊</a>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
        <div class="u-container-style u-group u-white u-group-1">
         
        </div>
        <div class="u-container-style u-group u-white u-group-2">
          <div class="u-container-layout u-container-layout-2">
            <a href="139992805" class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-3">發布案件</a>
            <a href="139992805" class="u-border-1 u-border-palette-3-light-1 u-btn u-btn-round u-button-style u-hover-palette-3-light-2 u-none u-radius-10 u-text-hover-white u-text-palette-3-light-1 u-btn-4">帳號管理</a>
          </div>
        </div>
      </div></header>
    <section class="u-align-center u-clearfix u-grey-5 u-section-1" id="sec-8eb0">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-layout-cell u-size-12 u-layout-cell-1">
                <div class="u-container-layout u-container-layout-1">
                  <div class="u-accordion u-collapsed-by-default u-spacing-15 u-accordion-1">
                    <div class="u-accordion-item">
                      <a class="u-accordion-link u-border-2 u-border-grey-5 u-button-style u-grey-5 u-radius-6 u-text-active-palette-1-light-1 u-text-hover-palette-1-light-1 u-accordion-link-1" id="link-accordion-0781" aria-controls="accordion-0781" aria-selected="false">
                        <span class="u-accordion-link-text">&nbsp; &nbsp; 會員管理</span><span class="u-accordion-link-icon u-icon u-icon-circle u-text-palette-5-dark-1 u-icon-1"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 451.847 451.847" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-eff5"></use></svg><svg class="u-svg-content" viewBox="0 0 451.847 451.847" x="0px" y="0px" id="svg-eff5" style="enable-background:new 0 0 451.847 451.847;"><g><path d="M225.923,354.706c-8.098,0-16.195-3.092-22.369-9.263L9.27,151.157c-12.359-12.359-12.359-32.397,0-44.751   c12.354-12.354,32.388-12.354,44.748,0l171.905,171.915l171.906-171.909c12.359-12.354,32.391-12.354,44.744,0   c12.365,12.354,12.365,32.392,0,44.751L248.292,345.449C242.115,351.621,234.018,354.706,225.923,354.706z"></path>
</g></svg></span>
                      </a>
                      <div class="u-accordion-pane u-container-style u-shape-rectangle u-white u-accordion-pane-1" id="accordion-0781" style="min-height:auto;" aria-labelledby="link-accordion-0781">
                        <div class="u-container-layout u-container-layout-2">
                          <a href="<%= request.getContextPath() %>/backend/accountmanager" class="u-align-left u-border-none u-btn u-btn-round u-button-style u-radius-6 u-text-hover-palette-1-light-1 u-white u-btn-1">帳號設置</a>
                          <a href="<%= request.getContextPath() %>/backend/personcontent" class="u-align-left u-border-none u-btn u-btn-round u-button-style u-radius-6 u-text-hover-palette-1-light-1 u-white u-btn-2">個人資料</a>
                          <a href="<%= request.getContextPath() %>/backend/casemanage" class="u-align-left u-border-none u-btn u-btn-round u-button-style u-radius-6 u-text-hover-palette-1-light-1 u-white u-btn-3">案件管理</a>
                        
                        </div>
                      </div>
                    </div>
                  </div>
                  <a href="<%= request.getContextPath() %>/backend/systemnotice" class="u-active-grey-15 u-border-none u-btn u-button-style u-grey-5 u-hover-grey-15 u-text-active-palette-1-light-1 u-text-hover-palette-1-light-1 u-btn-5">&nbsp; 系統通知</a><span class="u-icon u-icon-circle u-text-palette-5-dark-1 u-icon-2" data-href="https://nicepage.com/k/competition-website-templates"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="-43 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-c580"></use></svg><svg class="u-svg-content" viewBox="-43 0 512 512" id="svg-c580"><path d="m413.417969 360.8125c-32.253907-27.265625-50.75-67.117188-50.75-109.335938v-59.476562c0-75.070312-55.765625-137.214844-128-147.625v-23.042969c0-11.796875-9.558594-21.332031-21.335938-21.332031-11.773437 0-21.332031 9.535156-21.332031 21.332031v23.042969c-72.257812 10.410156-128 72.554688-128 147.625v59.476562c0 42.21875-18.496094 82.070313-50.945312 109.503907-8.296876 7.105469-13.054688 17.429687-13.054688 28.351562 0 20.589844 16.746094 37.335938 37.332031 37.335938h352c20.589844 0 37.335938-16.746094 37.335938-37.335938 0-10.921875-4.757813-21.246093-13.25-28.519531zm0 0"></path><path d="m213.332031 512c38.636719 0 70.957031-27.542969 78.378907-64h-156.757813c7.425781 36.457031 39.746094 64 78.378906 64zm0 0"></path></svg></span>
                  <a href="https://nicepage.com/c/shapes-website-templates" class="u-active-grey-15 u-border-none u-btn u-button-style u-grey-5 u-hover-grey-15 u-text-active-palette-1-light-1 u-text-hover-palette-1-light-1 u-btn-6">訊息</a><span class="u-icon u-icon-circle u-icon-3" data-href="https://nicepage.com/c/fashion-beauty-website-templates"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 -67 380 380" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-de85"></use></svg><svg class="u-svg-content" viewBox="0 -67 380 380" id="svg-de85"><path d="m30 0h320c14.402344.0390625 26.761719 10.261719 29.5 24.398438l-189.5 105.601562-189.5-105.601562c2.738281-14.136719 15.097656-24.3593755 29.5-24.398438zm320 246.601562h-320c-16.546875-.050781-29.953125-13.453124-30-30v-169.601562l185.101562 103.199219c1.5.824219 3.183594 1.273437 4.898438 1.300781 1.722656.019531 3.414062-.429688 4.898438-1.300781l185.101562-103.199219v169.601562c-.011719 16.5625-13.4375 29.984376-30 30zm0 0"></path></svg></span>
                  <a href="https://nicepage.com/c/shapes-website-templates" class="u-active-grey-15 u-border-none u-btn u-button-style u-grey-5 u-hover-grey-15 u-text-active-palette-1-light-1 u-text-hover-palette-1-light-1 u-btn-7"  name="logout" onclick="logout()">登出</a><span class="u-icon u-icon-circle u-icon-4" data-href="https://nicepage.com/c/video-website-templates"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 511 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-5881"></use></svg><svg class="u-svg-content" viewBox="0 0 511 512" id="svg-5881"><path d="m361.5 392v40c0 44.113281-35.886719 80-80 80h-201c-44.113281 0-80-35.886719-80-80v-352c0-44.113281 35.886719-80 80-80h201c44.113281 0 80 35.886719 80 80v40c0 11.046875-8.953125 20-20 20s-20-8.953125-20-20v-40c0-22.054688-17.945312-40-40-40h-201c-22.054688 0-40 17.945312-40 40v352c0 22.054688 17.945312 40 40 40h201c22.054688 0 40-17.945312 40-40v-40c0-11.046875 8.953125-20 20-20s20 8.953125 20 20zm136.355469-170.355469-44.785157-44.785156c-7.8125-7.8125-20.476562-7.8125-28.285156 0-7.8125 7.808594-7.8125 20.472656 0 28.28125l31.855469 31.859375h-240.140625c-11.046875 0-20 8.953125-20 20s8.953125 20 20 20h240.140625l-31.855469 31.859375c-7.8125 7.808594-7.8125 20.472656 0 28.28125 3.90625 3.90625 9.023438 5.859375 14.140625 5.859375 5.121094 0 10.238281-1.953125 14.144531-5.859375l44.785157-44.785156c19.496093-19.496094 19.496093-51.214844 0-70.710938zm0 0"></path></svg></span>
                </div>
              </div>
              <div class="u-container-style u-layout-cell u-size-48 u-layout-cell-2">
                <div class="u-container-layout u-container-layout-3">
                  <div class="u-border-1 u-border-palette-5-light-1 u-container-style u-group u-radius-30 u-shape-round u-group-1">
                    <div class="u-container-layout u-container-layout-4">
                      <p class="u-large-text u-text u-text-default u-text-variant u-text-1">
                        <span style="font-weight: 700;">系統訊息</span>
                        <span style="font-weight: 700;"></span>
                      </p>
                      <div class="u-container-style u-group u-shape-rectangle u-group-2">
                        <div class="u-container-layout u-container-layout-5">
                          <nav class="u-dropdown-icon u-menu u-menu-dropdown u-offcanvas u-menu-1">
                            <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
                              <a class="u-button-style u-custom-active-color u-custom-border u-custom-border-color u-custom-border-radius u-custom-color u-custom-left-right-menu-spacing u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link" href="#">
                                <svg><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
                              </a>
                            </div>
                            <div class="u-custom-menu u-nav-container">
                              <ul class="u-nav u-spacing-20 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-active-white u-border-1 u-border-palette-5-dark-2 u-button-style u-nav-link u-radius-5 u-text-active-palette-5-dark-2 u-text-hover-palette-2-base u-text-palette-5-dark-2 u-white" href=# style="padding: 10px 36px;">全部</a><div class="u-nav-popup"><ul class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-2"><li class="u-nav-item"><a class="u-active-white u-button-style u-hover-palette-5-light-2 u-nav-link u-white" href="<%= request.getContextPath() %>/backend/ordernotice">系統通知</a>
</li><li class="u-nav-item"><a class="u-active-white u-button-style u-hover-palette-5-light-2 u-nav-link u-white" href="<%= request.getContextPath() %>/backend/systemnotice">系統公告</a>
</li></ul>
</div>
</li></ul>
                            </div>
                            <div class="u-custom-menu u-nav-container-collapse">
                              <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                                <div class="u-sidenav-overflow">
                                  <div class="u-menu-close"></div>
                                  <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-3"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="全部.html" style="padding: 10px 36px;">全部</a><div class="u-nav-popup"><ul class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-4"><li class="u-nav-item"><a class="u-button-style u-nav-link" >系統通知</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link">系統公告</a>
</li></ul>
</div>
</li></ul>
                                </div>
                              </div>
                              <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
                            </div>
                          </nav>
                          <p class="u-small-text u-text u-text-default u-text-palette-5-dark-2 u-text-variant u-text-2">篩選</p>
                        </div>
                      </div>
                      <div class="u-border-1 u-border-palette-5-light-1 u-container-style u-group u-radius-5 u-shape-round u-white u-group-3">
                        <div class="u-container-layout u-container-layout-6">
                          <div class="u-container-style u-group u-shape-rectangle u-group-4">
                            <div class="u-container-layout u-valign-middle u-container-layout-7">
                              <img class="u-image u-image-default u-preserve-proportions u-image-1" src="../resources/images/letter.png" alt="" data-image-width="512" data-image-height="512">
                            </div>
                          </div>
                          
                          <div class="u-border-1 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-5">
                            <div class="u-container-layout u-container-layout-8">
                          
                          
							
							
                             <!-- 訂單 notice_content
							<%= request.getAttribute("noticecontent") %>
							
							
							
							
							
							
							
							
                            </div>
                          </div>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-6">
                            <div class="u-container-layout u-container-layout-9">
                           <!--  放案件連結 -->
                           <!-- <input type="button" value="link" name="link1" style="width:50px;height:30px;"> -->
                            </div>
                          </div>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-7">
                            <div class="u-container-layout u-container-layout-10">
                          
                          <!--  訂單  notice_title -->
							<%-- <%= request.getAttribute("noticetitle") %> --%>
							
                            </div>
                          </div>
                          
                          <p class="u-large-text u-text u-text-default u-text-variant u-text-3"><%= request.getAttribute("noticesort") %></p>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-8">
                            <div class="u-container-layout u-container-layout-11">
                            
                            <!-- 訂單 notice_date -->
							<%-- <%= request.getAttribute("noticedate") %> --%>
							
							
                            </div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="u-border-1 u-border-palette-5-light-1 u-container-style u-group u-radius-5 u-shape-round u-white u-group-9">
                        <div class="u-container-layout u-container-layout-12">
                       
                          <div class="u-container-style u-group u-shape-rectangle u-group-10">
                            <div class="u-container-layout u-valign-middle u-container-layout-13">
                               <img class="u-image u-image-default u-preserve-proportions u-image-1" src="../resources/images/letter.png" alt="" data-image-width="512" data-image-height="512">
                            </div>
                          </div>
                          
                          <div class="u-border-1 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-11">
                            <div class="u-container-layout u-container-layout-14">
                            
                            <!-- 公告 notice_content -->
<%--                             <%= request.getAttribute("noticecontent") %> --%>
                           
		            
                              
                              <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-12">
                                <div class="u-container-layout u-container-layout-15">
                                
                               <!--  公告  notice_title -->
                              <%--  <%= request.getAttribute("noticetitle") %> --%>
                               
                               </div>
                              </div>
                            </div>
                          </div>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-13">
                            <div class="u-container-layout u-container-layout-16"></div>
                           <!--  放案件連結 -->
                           <!-- <input type="button" value="link" name="link2" style="width:50px;height:30px;"> -->
                          </div>
                          
                          <p class="u-large-text u-text u-text-default u-text-variant u-text-4">公告</p>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-14">
                            <div class="u-container-layout u-container-layout-17">
                            
                            <!-- 公告 notice_date -->
                          <%-- 	<%= request.getAttribute("noticedate") %> --%>
							
							</div>
                          </div>
                        </div>
                      </div>
                      
                     <!--  ----------- -->
                      
                       <div class="u-border-1 u-border-palette-5-light-1 u-container-style u-group u-radius-5 u-shape-round u-white u-group-9">
                        <div class="u-container-layout u-container-layout-12">
                       
                          <div class="u-container-style u-group u-shape-rectangle u-group-10">
                            <div class="u-container-layout u-valign-middle u-container-layout-13">
                               <img class="u-image u-image-default u-preserve-proportions u-image-1" src="../resources/images/letter.png" alt="" data-image-width="512" data-image-height="512">
                            </div>
                          </div>
                          
                          <div class="u-border-1 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-11">
                            <div class="u-container-layout u-container-layout-14">
                            
                            <!-- 公告 notice_content -->
                          <%--  <%= request.getAttribute("noticecontent") %> --%>
		            
                              
                              <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-12">
                                <div class="u-container-layout u-container-layout-15">
                                
                               <!--  公告  notice_title -->
                               <%-- <%= request.getAttribute("noticetitle") %> --%>
                               
                               </div>
                              </div>
                            </div>
                          </div>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-13">
                            <div class="u-container-layout u-container-layout-16"></div>
                           <!--  放案件連結 -->
                           <!-- <input type="button" value="link" name="link2" style="width:50px;height:30px;"> -->
                          </div>
                          
                          <p class="u-large-text u-text u-text-default u-text-variant u-text-4">公告</p>
                          
                          <div class="u-border-0 u-border-grey-75 u-container-style u-group u-shape-rectangle u-group-14">
                            <div class="u-container-layout u-container-layout-17">
                            
                            <!-- 公告 notice_date -->
<%--                           <%= request.getAttribute("noticedate") %> --%>
							
							</div>
                          </div>
                        </div>
                      </div>
                      
                      
                      
                      <!-- ------------- -->
                      
                      <div class="u-container-style u-group u-group-15">
                        <div class="u-container-layout u-container-layout-18">
             
                          <a href="https://nicepage.com/website-templates" class="u-border-none u-btn u-button-style u-none u-text-hover-palette-1-base u-text-palette-5-dark-2 u-btn-8"><span class="u-icon u-icon-5"><svg class="u-svg-content" viewBox="0 0 612 612" x="0px" y="0px" style="width: 1em; height: 1em;"><g><g id="_x31_0_25_"><g><path d="M306,0C136.992,0,0,136.992,0,306s136.992,306,306,306c168.988,0,306-136.992,306-306S475.008,0,306,0z M306,573.75     C158.125,573.75,38.25,453.875,38.25,306C38.25,158.125,158.125,38.25,306,38.25c147.875,0,267.75,119.875,267.75,267.75     C573.75,453.875,453.875,573.75,306,573.75z M392.751,142.749c-7.478-7.478-19.584-7.478-27.043,0l-146.44,146.44     c-4.59,4.59-6.005,10.863-4.953,16.811c-1.052,5.929,0.382,12.221,4.953,16.811l146.44,146.44c7.479,7.459,19.584,7.459,27.043,0     c7.478-7.478,7.478-19.584,0-27.043L256.543,306l136.188-136.189C400.21,162.333,400.21,150.227,392.751,142.749z"></path>
</g>
</g>
</g></svg><img></span>&nbsp;上一頁
                          </a>
                          <a href="https://nicepage.com/website-templates" class="u-border-none u-btn u-button-style u-none u-text-hover-palette-1-base u-text-palette-5-dark-2 u-btn-9">下一頁&nbsp;<span class="u-icon u-icon-6"><svg class="u-svg-content" viewBox="0 0 338.352 338.352" x="0px" y="0px" style="width: 1em; height: 1em;"><g><g><path d="M169.176,0C75.601,0,0,75.514,0,169.176s75.514,169.176,169.176,169.176s169.176-75.514,169.176-169.176    S262.752,0,169.176,0z M169.176,315.731c-81.191,0-146.556-65.365-146.556-146.556S87.986,22.619,169.176,22.619    s146.556,65.365,146.556,146.556S250.367,315.731,169.176,315.731z"></path>
</g>
</g><g><g><path d="M231.187,162.382l-74.396-74.396c-4.472-4.472-11.267-4.472-15.825,0c-4.472,4.472-4.472,11.267,0,15.826l65.365,65.365    l-65.365,65.365c-4.472,4.472-4.472,11.267,0,15.825c2.236,2.236,4.472,3.354,7.913,3.354c2.236,0,5.677-1.118,9.03-2.236    l73.278-73.278c2.236-2.236,3.355-4.472,3.355-7.913C234.542,166.94,233.424,164.618,231.187,162.382z"></path>
</g>
</g></svg><img></span> &nbsp;<span class="u-icon"></span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-70 u-footer" id="sec-c7c8"><p class="u-small-text u-text u-text-variant u-text-1">Copyright @ dodo 2021</p><nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
        <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
          <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
            <svg><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
          </a>
        </div>
        <div class="u-custom-menu u-nav-container">
          <ul class="u-nav u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base" style="padding: 10px 96px;">聯絡我們</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-1-base" style="padding: 10px 96px;">常見問題</a>
</li></ul>
        </div>
        <div class="u-custom-menu u-nav-container-collapse">
          <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
            <div class="u-sidenav-overflow">
              <div class="u-menu-close"></div>
              <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" style="padding: 10px 96px;">聯絡我們</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" style="padding: 10px 96px;">常見問題</a>
</li></ul>
            </div>
          </div>
          <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
        </div>
      </nav>
      
      </footer>
      
      
        <script type="text/javascript">

    //登出
    function logout(){
    	
    	window.location.href = '/PaintPartyMvcProject/logout'
    }
    
    </script>
  </body>
</html>