/** 
 * changeSkin.js
 * 框架页换肤操作js
 *
 */
//网站换肤
$(function () {
	addChangeSkinEvent();
	selectedCurrentSkin();
});

//切换皮肤操作
function switchSkin(_skinName) {
	$("#" + _skinName).addClass("selected").siblings().removeClass("selected");  //去掉其他同辈<li>元素的选中
	$("#web_skin").attr("href", app_skin_path + _skinName + ".css"); //设置不同皮肤
	$("#mainFrame").contents().find("#web_skin").attr("href", app_skin_path + _skinName+".css");//设置显示区的样式
	//$.cookie(app_cookie_skin, _skinName, {path:"/", expires:10});
	app_setCookie(app_cookie_skin, _skinName);
}
//添加皮肤选择监听
function addChangeSkinEvent() {
	var $li = $("#ul_skins li");
	$li.click(function () {
		switchSkin(this.id);
	});
}

function selectedCurrentSkin() {
	var _skinName = app_getCookie(app_cookie_skin);
	if(!_skinName)
	{
		_skinName = app_default_skin;
	}
	$("#" + _skinName).addClass("selected").siblings().removeClass("selected");  //去掉其他同辈<li>元素的选中
}
