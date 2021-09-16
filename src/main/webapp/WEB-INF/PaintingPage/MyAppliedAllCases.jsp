<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<div class="u-list u-list-2">
	<div class="u-repeater u-repeater-2">
    <div
        class="u-align-left u-container-style u-list-item u-repeater-item">
        <div
            class="u-container-layout u-similar-container u-container-layout-7">
            <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1"
                data-position="">
                <div class="menu-collapse"
                    style="font-size: 1.25rem; font-weight: 700;">
      <a class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-color u-custom-hover-color u-custom-text-hover-color u-nav-link"
          href="#">
          <svg>
              <use xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#menu-hamburger">
              </use>
          </svg>
          <svg version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              xmlns:xlink="http://www.w3.org/1999/xlink">
              <defs>
                  <symbol
                      id="menu-hamburger"
                      viewBox="0 0 16 16"
                      style="width: 16px; height: 16px;">
                        <rect y="1"
                            width="16"
                            height="2">
                        </rect>
                        <rect y="7"
                            width="16"
                            height="2">
                        </rect>
                        <rect y="13"
                            width="16"
                            height="2">
                        </rect>
                    </symbol>
                </defs>
            </svg>
        </a>
    </div>


    <div
        class="u-custom-menu u-nav-container">
        <ul
            class="u-nav u-unstyled u-nav-1">
            <li class="u-nav-item"><a
                    class="u-border-2 u-border-grey-75 u-button-style u-hover-palette-5-light-1 u-nav-link"
                    href="####">排序</a>
                <div
                    class="u-nav-popup">
                    <ul
                        class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-2">
                        <li
                            class="u-nav-item">
                            <a class="u-button-style u-nav-link u-palette-3-light-3"
                                href="####">由新到舊</a>
                        </li>
                        <li
                            class="u-nav-item">
                            <a class="u-button-style u-nav-link u-palette-3-light-3"
                                href="####">由舊到新</a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <div
        class="u-custom-menu u-nav-container-collapse">
        <div
            class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
            <div
                class="u-sidenav-overflow">
                <div
                    class="u-menu-close">
                </div>
                <ul
                    class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-3">
                    <li
                        class="u-nav-item">
                        <a class="u-button-style u-nav-link"
                            href="####">排序</a>
                        <div
                            class="u-nav-popup">
                            <ul
                                class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-4">
                                <li
                                    class="u-nav-item">
                                    <a class="u-button-style u-nav-link"
                                        href="####">由新到舊</a>
                                </li>
                                <li
                                    class="u-nav-item">
                                    <a class="u-button-style u-nav-link"
                                        href="####">由舊到新</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div
            class="u-black u-menu-overlay u-opacity u-opacity-70">
        </div>
    </div>
</nav>
<nav
    class="u-menu u-menu-dropdown u-offcanvas u-menu-2">
    <div class="menu-collapse"
        style="font-weight: 700; font-size: 1.25rem;">
      <a class="u-button-style u-custom-hover-color u-nav-link"
          href="#">
          <svg>
              <use xmlns:xlink="http://www.w3.org/1999/xlink"
                  xlink:href="#menu-hamburger">
              </use>
          </svg>
          <svg version="1.1"
              xmlns="http://www.w3.org/2000/svg"
              xmlns:xlink="http://www.w3.org/1999/xlink">
              <defs>
                  <symbol
                      id="menu-hamburger"
                      viewBox="0 0 16 16"
                      style="width: 16px; height: 16px;">
                                        <rect y="1"
                                            width="16"
                                            height="2">
                                        </rect>
                                        <rect y="7"
                                            width="16"
                                            height="2">
                                        </rect>
                                        <rect y="13"
                                            width="16"
                                            height="2">
                                        </rect>
                                    </symbol>
                                </defs>
                            </svg>
                        </a>
                    </div>





                </nav>
            </div>
        </div>
    </div>
	</div>

    <!-- 以上選單，以下空白準備填入  -->

    <div
    class="u-container-style u-group u-white u-group-2">
    <div
        class="u-container-layout u-container-layout-8" id="MyAppliedAllCasesPage">  <!-- 新增的元素，放在此區塊裡面 -->
        
        
         <script>
                
                    
	             $.ajax({
	                 url: `<%= request.getContextPath() %>/backend/myappliedallcases2`,                        // url位置
	                 type: 'post',                   // post/get
	                 error: function (xhr) { $("#MyAppliedAllCasesPage").html('請求失敗，請重新整理'); },      // 錯誤後執行的函數
	                 success: function (data) { 
	                	 $("#MyAppliedAllCasesPage").html(JSON.stringify(data));
	                 
	                 let i = 0; 
	  					
                     if(data[0]!=null){
                    	 for(i=0;i<data.length;i++){
                    		 
                    		 $("#MyAppliedAllCasesPage").append(`                                                                        
                    				 <div class="u-container-style u-group u-palette-5-light-2 u-group-17" >
                                     
                                     <div class="u-container-layout u-container-layout-26" >
                                     
                                     
                                         
                                         <h5 class="u-text u-text-default u-text-font u-text-16">
                                             
                                             <a class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-palette-1-base u-btn-19"
                                                 href="####">\${ data[i].case_title }</a>
                                         </h5>
                                         
                                         
                                         <div
                                             class="u-container-style u-group u-shape-rectangle u-group-18">
                                             <div
                                                 class="u-container-layout u-container-layout-27" >
                                                     
                                                     <div><b>應徵日期：</b>\${ data[i].apply_date }</div>
                                                     
                                             </div>
                                         </div>
                                         <div
                                             class="u-container-style u-group u-shape-rectangle u-group-19">
                                             <div
                                                 class="u-container-layout u-container-layout-28" >
                                             	<div style="padding-left:30px"><b>期望稿酬：</b>\${ data[i].price_expected } (NTD)</div>
                                             </div>
                                         </div>
                                         <div
                                             class="u-container-style u-group u-shape-rectangle u-group-20">
                                             <div
                                                 class="u-container-layout u-container-layout-29" >
                                             	<div><b>預估需時：</b>\${ data[i].case_time }天</div>
                                             </div>
                                         </div>
                                         
                                         <div style="display:flex;margin-left:50px;margin-top:-50px;"><b>發案者：</b><a href="####" target="_blank">\${ data[i].amember_name }</a></div>
                                         
                                      
                                     </div>
                                 </div>
`); //append end
                    		 
                    		 
                    	 }//end for
                    	 
                    	 
                    	 
                     }else{
                    	 
                    	 $("#MyAppliedAllCasesPage").html("暫無資料"); 
                    	 
                     }//end if
	                 
	                 
	                 
	                 
	                 
	                 }// end success
	             });//end ajax
                    
         </script>
        
        

    </div>
</div>


     <!-- 以上空白區塊，以下頁數  -->

     <div
     class="u-container-style u-group u-white u-group-7">
     <div
         class="u-container-layout u-container-layout-13">
         <a href="####"
             class="u-active-palette-1-light-1 u-border-none u-btn u-btn-round u-button-style u-hover-palette-1-base u-palette-1-base u-radius-6 u-btn-10">上一頁</a>
         <p class="u-text u-text-default u-text-6">X頁</p>
         <p class="u-text u-text-default u-text-7">／</p>
         <p class="u-text u-text-default u-text-8">X頁</p>
         <a href="####"
             class="u-active-palette-1-light-1 u-border-none u-btn u-btn-round u-button-style u-hover-palette-1-base u-palette-1-base u-radius-6 u-btn-11">下一頁</a>
     </div>
 </div>

 <!-------結束--------->




</body>
</html>