/**
 * common.js
 * 公共js，每个页面必须引入，需把该文件引入在自定义文件之前
 *
 * js定义规则：
 * 1、定义全局变量时名称前必须加上"app_"
 * 2、定义临时变量时名称前必须加上"_"
 * 3、定义方法名时需要在名称前加上文件名缩写 例如 app_initWebSkin 是以"app_"开头
 * 4、定义临时方法时需要在名称前加上"_",它是不允许别的页面调用的，只能本页面使用
 */
 
/******************************************导入页面必须的文件 start**************************************/
//文件中导入ico文件
var icoFile = '<link rel="Shortcut Icon" href="images/admin/logo.ico" type="image/x-icon">';
document.write(icoFile);

//文件中导入css文件
var cssFile = '<link rel="stylesheet" type="text/css" href="css/admin/common.css">';
document.write(cssFile);

//文件中导入js文件
var jsFile = '<script type="text/javascript" src="js/admin/jquery.js"><\/script>';
document.write(jsFile);
var jsFile2 = '<script type="text/javascript" src="js/admin/backspace.js"><\/script>';
document.write(jsFile2);
var jsFile3 = '<script type="text/javascript" src="js/common/mask.tip.js"><\/script>';
document.write(jsFile3);

/******************************************导入页面必须的文件 end**************************************/

/*系统全局变量(必须)*/
var app_cookie_skin="cookie_skin";
var app_skin_path = "css/admin/skin_";
var app_default_skin = "green";
var app_page_skin = "msdn";//分页样式



/***************************操作cookies工具函数 start********************************/
/**取cookies函数 */
function app_getCookie(name){
	var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	if(arr !== null)
	{ 
		return unescape(arr[2]);
	} 
	return null;
}
/**存放Cookies: 两个参数，一个是cookie的名子，一个是值*/
function app_setCookie(name,value){
	var Days = 30; //此 cookie 将被保存 30 天
	var exp  = new Date();	//new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";path=/;expires="+exp.toGMTString();
}
/**删除cookie*/
function app_delCookie(name){
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!== null) 
	{
		document.cookie= name + "="+cval+";path=/;expires="+exp.toGMTString();
	}
}
/***************************操作cookies工具函数 end********************************/

/***************************动态加载js文件工具函数 start********************************/
var filesadded=""; //保存已经绑定文件名字的数组变量 
function app_checkloadjscssfile(filename, filetype, id){ //检查
	if (filesadded.indexOf("["+filename+"]")==-1){// indexOf判断数组里是否有某一项 
	  app_loadjscssfile(filename, filetype, id); 
	  filesadded+="["+filename+"]"; //把文件名字添加到filesadded 
	} 
	else{
	  alert("【" + filename + "】file already added!");//如果已经存在就提示
	 } 
} 

function app_loadjscssfile(filename, filetype, id){ 
	if (filetype=="js"){ //判断文件类型 
	  var fileref=document.createElement('script');//创建标签 
	  if(undefined != id)
		  fileref.setAttribute("id", id);
	  fileref.setAttribute("type","text/javascript");//定义属性type的值为text/javascript 
	  fileref.setAttribute("src", filename);//文件的地址 
	} 
	else if (filetype=="css"){ //判断文件类型 
	  var fileref=document.createElement("link"); 
	  if(undefined != id)
		  fileref.setAttribute("id", id);
	  fileref.setAttribute("rel", "stylesheet") ;
	  fileref.setAttribute("type", "text/css") ; 
	  fileref.setAttribute("href", filename); 
	} 
	if (typeof fileref!="undefined") 
	{
	  document.getElementsByTagName("head")[0].appendChild(fileref) ;
	}
} 
/***************************动态加载js文件工具函数 start********************************/

/*页面皮肤对应分页皮肤*/
function app_exchangePageSkin(web_skin)
{
	switch(web_skin)
	{
		case 'green': 
			app_page_skin = "scott";
			break;
		case 'gray': 
			app_page_skin = "black";
			break;
		case 'blue': 
			app_page_skin = "msdn";
			break;
		default: app_page_skin = "quotes";
	}	
}

/*初始化皮肤*/
function app_initWebSkin(){
	var _cookie_skin = app_getCookie(app_cookie_skin);
	if(null == _cookie_skin)
	{
		_cookie_skin = app_default_skin;
	}
	//app_exchangePageSkin(_cookie_skin);//设置分页皮肤
	app_checkloadjscssfile(app_skin_path+_cookie_skin+".css", "css", "web_skin");
}

app_initWebSkin();//初始化页面皮肤

