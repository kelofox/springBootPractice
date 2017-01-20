$(document).ready(function(){
	var qrcodeContent = $("#qrcodeContent").val();
	var options = {
		// render method: 'canvas', 'image' or 'div'
		render: 'canvas',

		// version range somewhere in 1 .. 40 :qrcode圖形密集程度
		minVersion: 9,
		//maxVersion: 40,

		// error correction level: 'L', 'M', 'Q' or 'H'
		ecLevel: 'H',

		// offset in pixel if drawn onto existing canvas
		left: 0,
		top: 0,

		// size in pixel
		size: 200,

		// code color or image element :qrcode圖形顏色
		fill: '#000',

		// background color or image element, null for transparent background :qrcode背景顏色
		background: null,

		// content
		text: qrcodeContent,

		// corner radius relative to module width: 0.0 .. 0.5 :qrcode圖形圓角
		radius: 0.5,

		// quiet zone in modules  :外框留白程度,0 = 不留白
		quiet: 1,

		// modes
		// 0: normal		:純qrcode
		// 1: label strip	:整排留白嵌入文字
		// 2: label box		:嵌入文字
		// 3: image strip	:整排留白嵌入圖形
		// 4: image box		:嵌入圖形
		mode: 4,
		
		//嵌入文字/圖形size及位置(0.5 = 置中)
		mSize: 0.2,
		mPosX: 0.5,
		mPosY: 0.5,
		
		//嵌入文字內容,使用字型,字體顏色
		label: 'no label',
		fontname: 'sans',
		fontcolor: '#000',

		image: $('#qrCodeIco')[0]
	};

	$('#container').empty().qrcode(options);
});