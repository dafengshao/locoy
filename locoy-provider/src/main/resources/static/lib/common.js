function AutoScroll(obj) {
	$(obj).find("ul:first").animate({
		marginTop : "-1.5em"
	}, 500, function() {
		$(this).css({
			marginTop : "0em"
		}).find("li:first").appendTo(this);
	});
}
TouchSlide({
	slideCell : "#slideBox",
	titCell : ".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
	mainCell : ".bd ul",
	effect : "leftLoop",
	autoPage : true, //自动分页
	autoPlay : true
//自动播放
});

window._bd_share_config = {
	"common" : {
		"bdSnsKey" : {},
		"bdText" : "",
		"bdMini" : "2",
		"bdMiniList" : false,
		"bdPic" : "",
		"bdStyle" : "0",
		"bdSize" : "16"
	},
	"share" : {}
};
with (document)
	0[(getElementsByTagName('head')[0] || body)
			.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
			+ ~(-new Date() / 36e5)];

function b() {
	h = $(window).height();
	t = $(document).scrollTop();
	if (t > h) {
		$('#gotop').show();
	} else {
		$('#gotop').hide();
	}
}
$(document).ready(function(e) {
	b();
	$('#gotop').click(function() {
		//$(document).scrollTop(0);	
		$('html,body').animate({
			scrollTop : '0px'
		}, 200);
	});
	$('#code').hover(function() {
		$(this).attr('id', 'code_hover');
		$('#code_img').show();
	}, function() {
		$(this).attr('id', 'code');
		$('#code_img').hide();
	});
	setInterval('AutoScroll("#noteScroll")', 5000);
	$('a').click(function(){
		window.location.href = $(this).attr("data_href");
	});
});
$(window).scroll(function(e) {
	b();
});
