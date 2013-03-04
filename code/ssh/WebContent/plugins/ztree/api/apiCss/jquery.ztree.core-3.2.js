/*
 * JQuery zTree core 3.2
 * http://code.google.com/p/jquerytree/
 *
 * Copyright (c) 2010 Hunter.z (baby666.cn)
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2012-05-13
 */
(function(l){var D,E,F,G,H,I,p={},J={},s={},M=0,K={treeId:"",treeObj:null,view:{addDiyDom:null,autoCancelSelected:!0,dblClickExpand:!0,expandSpeed:"fast",fontCss:{},nameIsHTML:!1,selectedMulti:!0,showIcon:!0,showLine:!0,showTitle:!0},data:{key:{children:"children",name:"name",title:"",url:"url"},simpleData:{enable:!1,idKey:"id",pIdKey:"pId",rootPId:null},keep:{parent:!1,leaf:!1}},async:{enable:!1,contentType:"application/x-www-form-urlencoded",type:"post",dataType:"text",url:"",autoParam:[],otherParam:[],
dataFilter:null},callback:{beforeAsync:null,beforeClick:null,beforeRightClick:null,beforeMouseDown:null,beforeMouseUp:null,beforeExpand:null,beforeCollapse:null,beforeRemove:null,onAsyncError:null,onAsyncSuccess:null,onNodeCreated:null,onClick:null,onRightClick:null,onMouseDown:null,onMouseUp:null,onExpand:null,onCollapse:null,onRemove:null}},t=[function(b){var a=b.treeObj,c=f.event;a.unbind(c.NODECREATED);a.bind(c.NODECREATED,function(a,c,g){k.apply(b.callback.onNodeCreated,[a,c,g])});a.unbind(c.CLICK);
a.bind(c.CLICK,function(a,c,g,j,f){k.apply(b.callback.onClick,[c,g,j,f])});a.unbind(c.EXPAND);a.bind(c.EXPAND,function(a,c,g){k.apply(b.callback.onExpand,[a,c,g])});a.unbind(c.COLLAPSE);a.bind(c.COLLAPSE,function(a,c,g){k.apply(b.callback.onCollapse,[a,c,g])});a.unbind(c.ASYNC_SUCCESS);a.bind(c.ASYNC_SUCCESS,function(a,c,g,j){k.apply(b.callback.onAsyncSuccess,[a,c,g,j])});a.unbind(c.ASYNC_ERROR);a.bind(c.ASYNC_ERROR,function(a,c,g,j,f,h){k.apply(b.callback.onAsyncError,[a,c,g,j,f,h])})}],q=[function(b){var a=
h.getCache(b);a||(a={},h.setCache(b,a));a.nodes=[];a.doms=[]}],v=[function(b,a,c,d,e,g){if(c){var j=b.data.key.children;c.level=a;c.tId=b.treeId+"_"+ ++M;c.parentTId=d?d.tId:null;if(c[j]&&c[j].length>0){if(typeof c.open=="string")c.open=k.eqs(c.open,"true");c.open=!!c.open;c.isParent=!0;c.zAsync=!0}else{c.open=!1;if(typeof c.isParent=="string")c.isParent=k.eqs(c.isParent,"true");c.isParent=!!c.isParent;c.zAsync=!c.isParent}c.isFirstNode=e;c.isLastNode=g;c.getParentNode=function(){return h.getNodeCache(b,
c.parentTId)};c.getPreNode=function(){return h.getPreNode(b,c)};c.getNextNode=function(){return h.getNextNode(b,c)};c.isAjaxing=!1;h.fixPIdKeyValue(b,c)}}],w=[function(b){var a=b.target,c=p[b.data.treeId],d="",e=null,g="",j="",i=null,m=null,l=null;if(k.eqs(b.type,"mousedown"))j="mousedown";else if(k.eqs(b.type,"mouseup"))j="mouseup";else if(k.eqs(b.type,"contextmenu"))j="contextmenu";else if(k.eqs(b.type,"click"))if(k.eqs(a.tagName,"span")&&a.getAttribute("treeNode"+f.id.SWITCH)!==null)d=a.parentNode.id,
g="switchNode";else{if(l=k.getMDom(c,a,[{tagName:"a",attrName:"treeNode"+f.id.A}]))d=l.parentNode.id,g="clickNode"}else if(k.eqs(b.type,"dblclick")&&(j="dblclick",l=k.getMDom(c,a,[{tagName:"a",attrName:"treeNode"+f.id.A}])))d=l.parentNode.id,g="switchNode";if(j.length>0&&d.length==0&&(l=k.getMDom(c,a,[{tagName:"a",attrName:"treeNode"+f.id.A}])))d=l.parentNode.id;if(d.length>0)switch(e=h.getNodeCache(c,d),g){case "switchNode":e.isParent?k.eqs(b.type,"click")||k.eqs(b.type,"dblclick")&&k.apply(c.view.dblClickExpand,
[c.treeId,e],c.view.dblClickExpand)?i=D:g="":g="";break;case "clickNode":i=E}switch(j){case "mousedown":m=F;break;case "mouseup":m=G;break;case "dblclick":m=H;break;case "contextmenu":m=I}return{stop:!1,node:e,nodeEventType:g,nodeEventCallback:i,treeEventType:j,treeEventCallback:m}}],x=[function(b){var a=h.getRoot(b);a||(a={},h.setRoot(b,a));a.children=[];a.expandTriggerFlag=!1;a.curSelectedList=[];a.noSelection=!0;a.createdNodes=[]}],y=[],z=[],A=[],B=[],C=[],h={addNodeCache:function(b,a){h.getCache(b).nodes[a.tId]=
a},addAfterA:function(b){z.push(b)},addBeforeA:function(b){y.push(b)},addInnerAfterA:function(b){B.push(b)},addInnerBeforeA:function(b){A.push(b)},addInitBind:function(b){t.push(b)},addInitCache:function(b){q.push(b)},addInitNode:function(b){v.push(b)},addInitProxy:function(b){w.push(b)},addInitRoot:function(b){x.push(b)},addNodesData:function(b,a,c){var d=b.data.key.children;a[d]||(a[d]=[]);if(a[d].length>0)a[d][a[d].length-1].isLastNode=!1,i.setNodeLineIcos(b,a[d][a[d].length-1]);a.isParent=!0;
a[d]=a[d].concat(c)},addSelectedNode:function(b,a){var c=h.getRoot(b);h.isSelectedNode(b,a)||c.curSelectedList.push(a)},addCreatedNode:function(b,a){(b.callback.onNodeCreated||b.view.addDiyDom)&&h.getRoot(b).createdNodes.push(a)},addZTreeTools:function(b){C.push(b)},exSetting:function(b){l.extend(!0,K,b)},fixPIdKeyValue:function(b,a){b.data.simpleData.enable&&(a[b.data.simpleData.pIdKey]=a.parentTId?a.getParentNode()[b.data.simpleData.idKey]:b.data.simpleData.rootPId)},getAfterA:function(b,a,c){for(var d=
0,e=z.length;d<e;d++)z[d].apply(this,arguments)},getBeforeA:function(b,a,c){for(var d=0,e=y.length;d<e;d++)y[d].apply(this,arguments)},getInnerAfterA:function(b,a,c){for(var d=0,e=B.length;d<e;d++)B[d].apply(this,arguments)},getInnerBeforeA:function(b,a,c){for(var d=0,e=A.length;d<e;d++)A[d].apply(this,arguments)},getCache:function(b){return s[b.treeId]},getNextNode:function(b,a){if(!a)return null;var c=b.data.key.children,d=a.parentTId?a.getParentNode():h.getRoot(b);if(!a.isLastNode)if(a.isFirstNode)return d[c][1];
else for(var e=1,g=d[c].length-1;e<g;e++)if(d[c][e]===a)return d[c][e+1];return null},getNodeByParam:function(b,a,c,d){if(!a||!c)return null;for(var e=b.data.key.children,g=0,j=a.length;g<j;g++){if(a[g][c]==d)return a[g];var f=h.getNodeByParam(b,a[g][e],c,d);if(f)return f}return null},getNodeCache:function(b,a){if(!a)return null;var c=s[b.treeId].nodes[a];return c?c:null},getNodes:function(b){return h.getRoot(b)[b.data.key.children]},getNodesByParam:function(b,a,c,d){if(!a||!c)return[];for(var e=
b.data.key.children,g=[],j=0,f=a.length;j<f;j++)a[j][c]==d&&g.push(a[j]),g=g.concat(h.getNodesByParam(b,a[j][e],c,d));return g},getNodesByParamFuzzy:function(b,a,c,d){if(!a||!c)return[];for(var e=b.data.key.children,g=[],j=0,f=a.length;j<f;j++)typeof a[j][c]=="string"&&a[j][c].indexOf(d)>-1&&g.push(a[j]),g=g.concat(h.getNodesByParamFuzzy(b,a[j][e],c,d));return g},getNodesByFilter:function(b,a,c,d){if(!a)return d?null:[];for(var e=b.data.key.children,g=d?null:[],j=0,f=a.length;j<f;j++){if(k.apply(c,
[a[j]],!1)){if(d)return a[j];g.push(a[j])}var i=h.getNodesByFilter(b,a[j][e],c,d);if(d&&i)return i;g=d?i:g.concat(i)}return g},getPreNode:function(b,a){if(!a)return null;var c=b.data.key.children,d=a.parentTId?a.getParentNode():h.getRoot(b);if(!a.isFirstNode)if(a.isLastNode)return d[c][d[c].length-2];else for(var e=1,g=d[c].length-1;e<g;e++)if(d[c][e]===a)return d[c][e-1];return null},getRoot:function(b){return b?J[b.treeId]:null},getSetting:function(b){return p[b]},getSettings:function(){return p},
getTitleKey:function(b){return b.data.key.title===""?b.data.key.name:b.data.key.title},getZTreeTools:function(b){return(b=this.getRoot(this.getSetting(b)))?b.treeTools:null},initCache:function(b){for(var a=0,c=q.length;a<c;a++)q[a].apply(this,arguments)},initNode:function(b,a,c,d,e,g){for(var j=0,f=v.length;j<f;j++)v[j].apply(this,arguments)},initRoot:function(b){for(var a=0,c=x.length;a<c;a++)x[a].apply(this,arguments)},isSelectedNode:function(b,a){for(var c=h.getRoot(b),d=0,e=c.curSelectedList.length;d<
e;d++)if(a===c.curSelectedList[d])return!0;return!1},removeNodeCache:function(b,a){var c=b.data.key.children;if(a[c])for(var d=0,e=a[c].length;d<e;d++)arguments.callee(b,a[c][d]);delete h.getCache(b).nodes[a.tId]},removeSelectedNode:function(b,a){for(var c=h.getRoot(b),d=0,e=c.curSelectedList.length;d<e;d++)if(a===c.curSelectedList[d]||!h.getNodeCache(b,c.curSelectedList[d].tId))c.curSelectedList.splice(d,1),d--,e--},setCache:function(b,a){s[b.treeId]=a},setRoot:function(b,a){J[b.treeId]=a},setZTreeTools:function(b,
a){for(var c=0,d=C.length;c<d;c++)C[c].apply(this,arguments)},transformToArrayFormat:function(b,a){if(!a)return[];var c=b.data.key.children,d=[];if(k.isArray(a))for(var e=0,g=a.length;e<g;e++)d.push(a[e]),a[e][c]&&(d=d.concat(h.transformToArrayFormat(b,a[e][c])));else d.push(a),a[c]&&(d=d.concat(h.transformToArrayFormat(b,a[c])));return d},transformTozTreeFormat:function(b,a){var c,d,e=b.data.simpleData.idKey,g=b.data.simpleData.pIdKey,j=b.data.key.children;if(!e||e==""||!a)return[];if(k.isArray(a)){var f=
[],i=[];for(c=0,d=a.length;c<d;c++)i[a[c][e]]=a[c];for(c=0,d=a.length;c<d;c++)i[a[c][g]]&&a[c][e]!=a[c][g]?(i[a[c][g]][j]||(i[a[c][g]][j]=[]),i[a[c][g]][j].push(a[c])):f.push(a[c]);return f}else return[a]}},n={bindEvent:function(b){for(var a=0,c=t.length;a<c;a++)t[a].apply(this,arguments)},bindTree:function(b){var a={treeId:b.treeId},b=b.treeObj;b.unbind("click",n.proxy);b.bind("click",a,n.proxy);b.unbind("dblclick",n.proxy);b.bind("dblclick",a,n.proxy);b.unbind("mouseover",n.proxy);b.bind("mouseover",
a,n.proxy);b.unbind("mouseout",n.proxy);b.bind("mouseout",a,n.proxy);b.unbind("mousedown",n.proxy);b.bind("mousedown",a,n.proxy);b.unbind("mouseup",n.proxy);b.bind("mouseup",a,n.proxy);b.unbind("contextmenu",n.proxy);b.bind("contextmenu",a,n.proxy)},doProxy:function(b){for(var a=[],c=0,d=w.length;c<d;c++){var e=w[c].apply(this,arguments);a.push(e);if(e.stop)break}return a},proxy:function(b){var a=h.getSetting(b.data.treeId);if(!k.uCanDo(a,b))return!0;for(var c=n.doProxy(b),d=!0,e=!1,g=0,j=c.length;g<
j;g++){var f=c[g];f.nodeEventCallback&&(e=!0,d=f.nodeEventCallback.apply(f,[b,f.node])&&d);f.treeEventCallback&&(e=!0,d=f.treeEventCallback.apply(f,[b,f.node])&&d)}try{e&&l("input:focus").length==0&&k.noSel(a)}catch(i){}return d}};D=function(b,a){var c=p[b.data.treeId];if(a.open){if(k.apply(c.callback.beforeCollapse,[c.treeId,a],!0)==!1)return!0}else if(k.apply(c.callback.beforeExpand,[c.treeId,a],!0)==!1)return!0;h.getRoot(c).expandTriggerFlag=!0;i.switchNode(c,a);return!0};E=function(b,a){var c=
p[b.data.treeId],d=c.view.autoCancelSelected&&b.ctrlKey&&h.isSelectedNode(c,a)?0:c.view.autoCancelSelected&&b.ctrlKey&&c.view.selectedMulti?2:1;if(k.apply(c.callback.beforeClick,[c.treeId,a,d],!0)==!1)return!0;d===0?i.cancelPreSelectedNode(c,a):i.selectNode(c,a,d===2);c.treeObj.trigger(f.event.CLICK,[b,c.treeId,a,d]);return!0};F=function(b,a){var c=p[b.data.treeId];k.apply(c.callback.beforeMouseDown,[c.treeId,a],!0)&&k.apply(c.callback.onMouseDown,[b,c.treeId,a]);return!0};G=function(b,a){var c=p[b.data.treeId];
k.apply(c.callback.beforeMouseUp,[c.treeId,a],!0)&&k.apply(c.callback.onMouseUp,[b,c.treeId,a]);return!0};H=function(b,a){var c=p[b.data.treeId];k.apply(c.callback.beforeDblClick,[c.treeId,a],!0)&&k.apply(c.callback.onDblClick,[b,c.treeId,a]);return!0};I=function(b,a){var c=p[b.data.treeId];k.apply(c.callback.beforeRightClick,[c.treeId,a],!0)&&k.apply(c.callback.onRightClick,[b,c.treeId,a]);return typeof c.callback.onRightClick!="function"};var k={apply:function(b,a,c){return typeof b=="function"?
b.apply(L,a?a:[]):c},canAsync:function(b,a){var c=b.data.key.children;return b.async.enable&&a&&a.isParent&&!(a.zAsync||a[c]&&a[c].length>0)},clone:function(b){var a;if(b instanceof Array){a=[];for(var c=b.length;c--;)a[c]=arguments.callee(b[c]);return a}else if(typeof b=="function")return b;else if(b instanceof Object){a={};for(c in b)a[c]=arguments.callee(b[c]);return a}else return b},eqs:function(b,a){return b.toLowerCase()===a.toLowerCase()},isArray:function(b){return Object.prototype.toString.apply(b)===
"[object Array]"},getMDom:function(b,a,c){if(!a)return null;for(;a&&a.id!==b.treeId;){for(var d=0,e=c.length;a.tagName&&d<e;d++)if(k.eqs(a.tagName,c[d].tagName)&&a.getAttribute(c[d].attrName)!==null)return a;a=a.parentNode}return null},noSel:function(b){if(h.getRoot(b).noSelection)try{window.getSelection?window.getSelection().removeAllRanges():document.selection.empty()}catch(a){}},uCanDo:function(){return!0}},i={addNodes:function(b,a,c,d){if(!b.data.keep.leaf||!a||a.isParent)if(k.isArray(c)||(c=
[c]),b.data.simpleData.enable&&(c=h.transformTozTreeFormat(b,c)),a){var e=l("#"+a.tId+f.id.SWITCH),g=l("#"+a.tId+f.id.ICON),j=l("#"+a.tId+f.id.UL);if(!a.open)i.replaceSwitchClass(a,e,f.folder.CLOSE),i.replaceIcoClass(a,g,f.folder.CLOSE),a.open=!1,j.css({display:"none"});h.addNodesData(b,a,c);i.createNodes(b,a.level+1,c,a);d||i.expandCollapseParentNode(b,a,!0)}else h.addNodesData(b,h.getRoot(b),c),i.createNodes(b,0,c,null)},appendNodes:function(b,a,c,d,e,g){if(!c)return[];for(var j=[],l=b.data.key.children,
m=b.data.key.name,n=h.getTitleKey(b),p=0,N=c.length;p<N;p++){var o=c[p],u=(d?d:h.getRoot(b))[l].length==c.length&&p==0,r=p==c.length-1;e&&(h.initNode(b,a,o,d,u,r,g),h.addNodeCache(b,o));u=[];o[l]&&o[l].length>0&&(u=i.appendNodes(b,a+1,o[l],o,e,g&&o.open));if(g){var r=i.makeNodeUrl(b,o),s=i.makeNodeFontCss(b,o),t=[],q;for(q in s)t.push(q,":",s[q],";");j.push("<li id='",o.tId,"' class='level",o.level,"' tabindex='0' hidefocus='true' treenode>","<span id='",o.tId,f.id.SWITCH,"' title='' class='",i.makeNodeLineClass(b,
o),"' treeNode",f.id.SWITCH,"></span>");h.getBeforeA(b,o,j);j.push("<a id='",o.tId,f.id.A,"' class='level",o.level,"' treeNode",f.id.A,' onclick="',o.click||"",'" ',r!=null&&r.length>0?"href='"+r+"'":""," target='",i.makeNodeTarget(o),"' style='",t.join(""),"'");k.apply(b.view.showTitle,[b.treeId,o],b.view.showTitle)&&o[n]&&j.push("title='",o[n].replace(/'/g,"&#39;").replace(/</g,"&lt;").replace(/>/g,"&gt;"),"'");j.push(">");h.getInnerBeforeA(b,o,j);r=b.view.nameIsHTML?o[m]:o[m].replace(/&/g,"&amp;").replace(/</g,
"&lt;").replace(/>/g,"&gt;");j.push("<span id='",o.tId,f.id.ICON,"' title='' treeNode",f.id.ICON," class='",i.makeNodeIcoClass(b,o),"' style='",i.makeNodeIcoStyle(b,o),"'></span><span id='",o.tId,f.id.SPAN,"'>",r,"</span>");h.getInnerAfterA(b,o,j);j.push("</a>");h.getAfterA(b,o,j);o.isParent&&o.open&&i.makeUlHtml(b,o,j,u.join(""));j.push("</li>");h.addCreatedNode(b,o)}}return j},appendParentULDom:function(b,a){var c=[],d=l("#"+a.tId),e=l("#"+a.tId+f.id.UL),g=i.appendNodes(b,a.level+1,a[b.data.key.children],
a,!1,!0);i.makeUlHtml(b,a,c,g.join(""));!d.get(0)&&a.parentTId&&(i.appendParentULDom(b,a.getParentNode()),d=l("#"+a.tId));e.get(0)&&e.remove();d.append(c.join(""));i.createNodeCallback(b)},asyncNode:function(b,a,c,d){var e,g;if(a&&!a.isParent)return k.apply(d),!1;else if(a&&a.isAjaxing)return!1;else if(k.apply(b.callback.beforeAsync,[b.treeId,a],!0)==!1)return k.apply(d),!1;if(a)a.isAjaxing=!0,l("#"+a.tId+f.id.ICON).attr({style:"","class":"button ico_loading"});var j=b.async.contentType=="application/json",
h=j?"{":"",m="";for(e=0,g=b.async.autoParam.length;a&&e<g;e++){var n=b.async.autoParam[e].split("="),p=n;n.length>1&&(p=n[1],n=n[0]);j?(m=typeof a[n]=="string"?'"':"",h+='"'+p+('":'+m+a[n]).replace(/'/g,"\\'")+m+","):h+=p+("="+a[n]).replace(/&/g,"%26")+"&"}if(k.isArray(b.async.otherParam))for(e=0,g=b.async.otherParam.length;e<g;e+=2)j?(m=typeof b.async.otherParam[e+1]=="string"?'"':"",h+='"'+b.async.otherParam[e]+('":'+m+b.async.otherParam[e+1]).replace(/'/g,"\\'")+m+","):h+=b.async.otherParam[e]+
("="+b.async.otherParam[e+1]).replace(/&/g,"%26")+"&";else for(var q in b.async.otherParam)j?(m=typeof b.async.otherParam[q]=="string"?'"':"",h+='"'+q+('":'+m+b.async.otherParam[q]).replace(/'/g,"\\'")+m+","):h+=q+("="+b.async.otherParam[q]).replace(/&/g,"%26")+"&";h.length>1&&(h=h.substring(0,h.length-1));j&&(h+="}");l.ajax({contentType:b.async.contentType,type:b.async.type,url:k.apply(b.async.url,[b.treeId,a],b.async.url),data:h,dataType:b.async.dataType,success:function(e){var g=[];try{g=!e||e.length==
0?[]:typeof e=="string"?eval("("+e+")"):e}catch(j){}if(a)a.isAjaxing=null,a.zAsync=!0;i.setNodeLineIcos(b,a);g&&g!=""?(g=k.apply(b.async.dataFilter,[b.treeId,a,g],g),i.addNodes(b,a,g?k.clone(g):[],!!c)):i.addNodes(b,a,[],!!c);b.treeObj.trigger(f.event.ASYNC_SUCCESS,[b.treeId,a,e]);k.apply(d)},error:function(c,d,e){if(a)a.isAjaxing=null;i.setNodeLineIcos(b,a);b.treeObj.trigger(f.event.ASYNC_ERROR,[b.treeId,a,c,d,e])}});return!0},cancelPreSelectedNode:function(b,a){for(var c=h.getRoot(b).curSelectedList,
d=c.length-1;d>=0;d--)if(!a||a===c[d])if(l("#"+c[d].tId+f.id.A).removeClass(f.node.CURSELECTED),i.setNodeName(b,c[d]),a){h.removeSelectedNode(b,a);break}if(!a)h.getRoot(b).curSelectedList=[]},createNodeCallback:function(b){if(b.callback.onNodeCreated||b.view.addDiyDom)for(var a=h.getRoot(b);a.createdNodes.length>0;){var c=a.createdNodes.shift();k.apply(b.view.addDiyDom,[b.treeId,c]);b.callback.onNodeCreated&&b.treeObj.trigger(f.event.NODECREATED,[b.treeId,c])}},createNodes:function(b,a,c,d){if(c&&
c.length!=0){var e=h.getRoot(b),g=b.data.key.children,g=!d||d.open||!!l("#"+d[g][0].tId).get(0);e.createdNodes=[];a=i.appendNodes(b,a,c,d,!0,g);d?(d=l("#"+d.tId+f.id.UL),d.get(0)&&d.append(a.join(""))):b.treeObj.append(a.join(""));i.createNodeCallback(b)}},expandCollapseNode:function(b,a,c,d,e){var g=h.getRoot(b),j=b.data.key.children;if(a){if(g.expandTriggerFlag){var n=e,e=function(){n&&n();a.open?b.treeObj.trigger(f.event.EXPAND,[b.treeId,a]):b.treeObj.trigger(f.event.COLLAPSE,[b.treeId,a])};g.expandTriggerFlag=
!1}if(a.open==c)k.apply(e,[]);else{!a.open&&a.isParent&&(!l("#"+a.tId+f.id.UL).get(0)||a[j]&&a[j].length>0&&!l("#"+a[j][0].tId).get(0))&&i.appendParentULDom(b,a);var c=l("#"+a.tId+f.id.UL),g=l("#"+a.tId+f.id.SWITCH),m=l("#"+a.tId+f.id.ICON);a.isParent?(a.open=!a.open,a.iconOpen&&a.iconClose&&m.attr("style",i.makeNodeIcoStyle(b,a)),a.open?(i.replaceSwitchClass(a,g,f.folder.OPEN),i.replaceIcoClass(a,m,f.folder.OPEN),d==!1||b.view.expandSpeed==""?(c.show(),k.apply(e,[])):a[j]&&a[j].length>0?c.slideDown(b.view.expandSpeed,
e):(c.show(),k.apply(e,[]))):(i.replaceSwitchClass(a,g,f.folder.CLOSE),i.replaceIcoClass(a,m,f.folder.CLOSE),d==!1||b.view.expandSpeed==""||!(a[j]&&a[j].length>0)?(c.hide(),k.apply(e,[])):c.slideUp(b.view.expandSpeed,e))):k.apply(e,[])}}else k.apply(e,[])},expandCollapseParentNode:function(b,a,c,d,e){a&&(a.parentTId?(i.expandCollapseNode(b,a,c,d),a.parentTId&&i.expandCollapseParentNode(b,a.getParentNode(),c,d,e)):i.expandCollapseNode(b,a,c,d,e))},expandCollapseSonNode:function(b,a,c,d,e){var g=h.getRoot(b),
f=b.data.key.children,g=a?a[f]:g[f],f=a?!1:d,k=h.getRoot(b).expandTriggerFlag;h.getRoot(b).expandTriggerFlag=!1;if(g)for(var l=0,n=g.length;l<n;l++)g[l]&&i.expandCollapseSonNode(b,g[l],c,f);h.getRoot(b).expandTriggerFlag=k;i.expandCollapseNode(b,a,c,d,e)},makeNodeFontCss:function(b,a){var c=k.apply(b.view.fontCss,[b.treeId,a],b.view.fontCss);return c&&typeof c!="function"?c:{}},makeNodeIcoClass:function(b,a){var c=["ico"];a.isAjaxing||(c[0]=(a.iconSkin?a.iconSkin+"_":"")+c[0],a.isParent?c.push(a.open?
f.folder.OPEN:f.folder.CLOSE):c.push(f.folder.DOCU));return"button "+c.join("_")},makeNodeIcoStyle:function(b,a){var c=[];if(!a.isAjaxing){var d=a.isParent&&a.iconOpen&&a.iconClose?a.open?a.iconOpen:a.iconClose:a.icon;d&&c.push("background:url(",d,") 0 0 no-repeat;");(b.view.showIcon==!1||!k.apply(b.view.showIcon,[b.treeId,a],!0))&&c.push("width:0px;height:0px;")}return c.join("")},makeNodeLineClass:function(b,a){var c=[];b.view.showLine?a.level==0&&a.isFirstNode&&a.isLastNode?c.push(f.line.ROOT):
a.level==0&&a.isFirstNode?c.push(f.line.ROOTS):a.isLastNode?c.push(f.line.BOTTOM):c.push(f.line.CENTER):c.push(f.line.NOLINE);a.isParent?c.push(a.open?f.folder.OPEN:f.folder.CLOSE):c.push(f.folder.DOCU);return i.makeNodeLineClassEx(a)+c.join("_")},makeNodeLineClassEx:function(b){return"button level"+b.level+" switch "},makeNodeTarget:function(b){return b.target||"_blank"},makeNodeUrl:function(b,a){var c=b.data.key.url;return a[c]?a[c]:null},makeUlHtml:function(b,a,c,d){c.push("<ul id='",a.tId,f.id.UL,
"' class='level",a.level," ",i.makeUlLineClass(b,a),"' style='display:",a.open?"block":"none","'>");c.push(d);c.push("</ul>")},makeUlLineClass:function(b,a){return b.view.showLine&&!a.isLastNode?f.line.LINE:""},removeChildNodes:function(b,a){if(a){var c=b.data.key.children,d=a[c];if(d){for(var e=0,g=d.length;e<g;e++)h.removeNodeCache(b,d[e]);h.removeSelectedNode(b);delete a[c];b.data.keep.parent?l("#"+a.tId+f.id.UL).empty():(a.isParent=!1,a.open=!1,c=l("#"+a.tId+f.id.SWITCH),d=l("#"+a.tId+f.id.ICON),
i.replaceSwitchClass(a,c,f.folder.DOCU),i.replaceIcoClass(a,d,f.folder.DOCU),l("#"+a.tId+f.id.UL).remove())}}},removeNode:function(b,a){var c=h.getRoot(b),d=b.data.key.children,e=a.parentTId?a.getParentNode():c;a.isFirstNode=!1;a.isLastNode=!1;a.getPreNode=function(){return null};a.getNextNode=function(){return null};l("#"+a.tId).remove();h.removeNodeCache(b,a);h.removeSelectedNode(b,a);for(var g=0,j=e[d].length;g<j;g++)if(e[d][g].tId==a.tId){e[d].splice(g,1);break}var k;if(!b.data.keep.parent&&e[d].length<
1)e.isParent=!1,e.open=!1,g=l("#"+e.tId+f.id.UL),j=l("#"+e.tId+f.id.SWITCH),k=l("#"+e.tId+f.id.ICON),i.replaceSwitchClass(e,j,f.folder.DOCU),i.replaceIcoClass(e,k,f.folder.DOCU),g.css("display","none");else if(b.view.showLine&&e[d].length>0){var m=e[d][e[d].length-1];m.isLastNode=!0;m.isFirstNode=e[d].length==1;g=l("#"+m.tId+f.id.UL);j=l("#"+m.tId+f.id.SWITCH);k=l("#"+m.tId+f.id.ICON);e==c?e[d].length==1?i.replaceSwitchClass(m,j,f.line.ROOT):(c=l("#"+e[d][0].tId+f.id.SWITCH),i.replaceSwitchClass(e[d][0],
c,f.line.ROOTS),i.replaceSwitchClass(m,j,f.line.BOTTOM)):i.replaceSwitchClass(m,j,f.line.BOTTOM);g.removeClass(f.line.LINE)}},replaceIcoClass:function(b,a,c){if(a&&!b.isAjaxing&&(b=a.attr("class"),b!=void 0)){b=b.split("_");switch(c){case f.folder.OPEN:case f.folder.CLOSE:case f.folder.DOCU:b[b.length-1]=c}a.attr("class",b.join("_"))}},replaceSwitchClass:function(b,a,c){if(a){var d=a.attr("class");if(d!=void 0){d=d.split("_");switch(c){case f.line.ROOT:case f.line.ROOTS:case f.line.CENTER:case f.line.BOTTOM:case f.line.NOLINE:d[0]=
i.makeNodeLineClassEx(b)+c;break;case f.folder.OPEN:case f.folder.CLOSE:case f.folder.DOCU:d[1]=c}a.attr("class",d.join("_"));c!==f.folder.DOCU?a.removeAttr("disabled"):a.attr("disabled","disabled")}}},selectNode:function(b,a,c){c||i.cancelPreSelectedNode(b);l("#"+a.tId+f.id.A).addClass(f.node.CURSELECTED);h.addSelectedNode(b,a)},setNodeFontCss:function(b,a){var c=l("#"+a.tId+f.id.A),d=i.makeNodeFontCss(b,a);d&&c.css(d)},setNodeLineIcos:function(b,a){if(a){var c=l("#"+a.tId+f.id.SWITCH),d=l("#"+a.tId+
f.id.UL),e=l("#"+a.tId+f.id.ICON),g=i.makeUlLineClass(b,a);g.length==0?d.removeClass(f.line.LINE):d.addClass(g);c.attr("class",i.makeNodeLineClass(b,a));a.isParent?c.removeAttr("disabled"):c.attr("disabled","disabled");e.removeAttr("style");e.attr("style",i.makeNodeIcoStyle(b,a));e.attr("class",i.makeNodeIcoClass(b,a))}},setNodeName:function(b,a){var c=b.data.key.name,d=h.getTitleKey(b),e=l("#"+a.tId+f.id.SPAN);e.empty();b.view.nameIsHTML?e.html(a[c]):e.text(a[c]);k.apply(b.view.showTitle,[b.treeId,
a],b.view.showTitle)&&a[d]&&l("#"+a.tId+f.id.A).attr("title",a[d])},setNodeTarget:function(b){l("#"+b.tId+f.id.A).attr("target",i.makeNodeTarget(b))},setNodeUrl:function(b,a){var c=l("#"+a.tId+f.id.A),d=i.makeNodeUrl(b,a);d==null||d.length==0?c.removeAttr("href"):c.attr("href",d)},switchNode:function(b,a){a.open||!k.canAsync(b,a)?i.expandCollapseNode(b,a,!a.open):b.async.enable?i.asyncNode(b,a)||i.expandCollapseNode(b,a,!a.open):a&&i.expandCollapseNode(b,a,!a.open)}};l.fn.zTree={consts:{event:{NODECREATED:"ztree_nodeCreated",
CLICK:"ztree_click",EXPAND:"ztree_expand",COLLAPSE:"ztree_collapse",ASYNC_SUCCESS:"ztree_async_success",ASYNC_ERROR:"ztree_async_error"},id:{A:"_a",ICON:"_ico",SPAN:"_span",SWITCH:"_switch",UL:"_ul"},line:{ROOT:"root",ROOTS:"roots",CENTER:"center",BOTTOM:"bottom",NOLINE:"noline",LINE:"line"},folder:{OPEN:"open",CLOSE:"close",DOCU:"docu"},node:{CURSELECTED:"curSelectedNode"}},_z:{tools:k,view:i,event:n,data:h},getZTreeObj:function(b){return(b=h.getZTreeTools(b))?b:null},init:function(b,a,c){var d=
k.clone(K);l.extend(!0,d,a);d.treeId=b.attr("id");d.treeObj=b;d.treeObj.empty();p[d.treeId]=d;if(l.browser.msie&&parseInt(l.browser.version)<7)d.view.expandSpeed="";h.initRoot(d);b=h.getRoot(d);a=d.data.key.children;c=c?k.clone(k.isArray(c)?c:[c]):[];b[a]=d.data.simpleData.enable?h.transformTozTreeFormat(d,c):c;h.initCache(d);n.bindTree(d);n.bindEvent(d);c={setting:d,addNodes:function(a,b,c){function f(){i.addNodes(d,a,h,c==!0)}if(!b)return null;a||(a=null);if(a&&!a.isParent&&d.data.keep.leaf)return null;
var h=k.clone(k.isArray(b)?b:[b]);k.canAsync(d,a)?i.asyncNode(d,a,c,f):f();return h},cancelSelectedNode:function(a){i.cancelPreSelectedNode(this.setting,a)},expandAll:function(a){a=!!a;i.expandCollapseSonNode(this.setting,null,a,!0);return a},expandNode:function(a,b,c,f,m){if(!a||!a.isParent)return null;b!==!0&&b!==!1&&(b=!a.open);if((m=!!m)&&b&&k.apply(d.callback.beforeExpand,[d.treeId,a],!0)==!1)return null;else if(m&&!b&&k.apply(d.callback.beforeCollapse,[d.treeId,a],!0)==!1)return null;b&&a.parentTId&&
i.expandCollapseParentNode(this.setting,a.getParentNode(),b,!1);if(b===a.open&&!c)return null;h.getRoot(d).expandTriggerFlag=m;c?i.expandCollapseSonNode(this.setting,a,b,!0,function(){f!==!1&&l("#"+a.tId).focus().blur()}):(a.open=!b,i.switchNode(this.setting,a),f!==!1&&l("#"+a.tId).focus().blur());return b},getNodes:function(){return h.getNodes(this.setting)},getNodeByParam:function(a,b,c){return!a?null:h.getNodeByParam(this.setting,c?c[this.setting.data.key.children]:h.getNodes(this.setting),a,b)},
getNodeByTId:function(a){return h.getNodeCache(this.setting,a)},getNodesByParam:function(a,b,c){return!a?null:h.getNodesByParam(this.setting,c?c[this.setting.data.key.children]:h.getNodes(this.setting),a,b)},getNodesByParamFuzzy:function(a,b,c){return!a?null:h.getNodesByParamFuzzy(this.setting,c?c[this.setting.data.key.children]:h.getNodes(this.setting),a,b)},getNodesByFilter:function(a,b,c){b=!!b;return!a||typeof a!="function"?b?null:[]:h.getNodesByFilter(this.setting,c?c[this.setting.data.key.children]:
h.getNodes(this.setting),a,b)},getNodeIndex:function(a){if(!a)return null;for(var b=d.data.key.children,c=a.parentTId?a.getParentNode():h.getRoot(this.setting),f=0,i=c[b].length;f<i;f++)if(c[b][f]==a)return f;return-1},getSelectedNodes:function(){for(var a=[],b=h.getRoot(this.setting).curSelectedList,c=0,d=b.length;c<d;c++)a.push(b[c]);return a},isSelectedNode:function(a){return h.isSelectedNode(this.setting,a)},reAsyncChildNodes:function(a,b,c){if(this.setting.async.enable){var d=!a;d&&(a=h.getRoot(this.setting));
b=="refresh"&&(a[this.setting.data.key.children]=[],d?this.setting.treeObj.empty():l("#"+a.tId+f.id.UL).empty());i.asyncNode(this.setting,d?null:a,!!c)}},refresh:function(){this.setting.treeObj.empty();var a=h.getRoot(this.setting),b=a[this.setting.data.key.children];h.initRoot(this.setting);a[this.setting.data.key.children]=b;h.initCache(this.setting);i.createNodes(this.setting,0,a[this.setting.data.key.children])},removeChildNodes:function(a){if(!a)return null;var b=a[d.data.key.children];i.removeChildNodes(d,
a);return b?b:null},removeNode:function(a,b){a&&(b=!!b,b&&k.apply(d.callback.beforeRemove,[d.treeId,a],!0)==!1||(i.removeNode(d,a),b&&this.setting.treeObj.trigger(f.event.REMOVE,[d.treeId,a])))},selectNode:function(a,b){a&&k.uCanDo(this.setting)&&(b=d.view.selectedMulti&&b,a.parentTId?i.expandCollapseParentNode(this.setting,a.getParentNode(),!0,!1,function(){l("#"+a.tId).focus().blur()}):l("#"+a.tId).focus().blur(),i.selectNode(this.setting,a,b))},transformTozTreeNodes:function(a){return h.transformTozTreeFormat(this.setting,
a)},transformToArray:function(a){return h.transformToArrayFormat(this.setting,a)},updateNode:function(a){a&&l("#"+a.tId).get(0)&&k.uCanDo(this.setting)&&(i.setNodeName(this.setting,a),i.setNodeTarget(a),i.setNodeUrl(this.setting,a),i.setNodeLineIcos(this.setting,a),i.setNodeFontCss(this.setting,a))}};b.treeTools=c;h.setZTreeTools(d,c);b[a]&&b[a].length>0?i.createNodes(d,0,b[a]):d.async.enable&&d.async.url&&d.async.url!==""&&i.asyncNode(d);return c}};var L=l.fn.zTree,f=L.consts})(jQuery);
