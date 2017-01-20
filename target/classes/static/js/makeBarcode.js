$(document).ready(function(){
   //barcode值
   var value = $("#barcodeContent").val();;
   
   //barcode種類 :  
   //ean8 ean13 upc std25 int25 code11 code39 code93 code128 codabar msi datamatrix
   var btype = "code128";
   
   //輸出格式 : css bmp svg canvas(只有css格式適用IE)
   var renderer = "css";
   
   //其他設定
   var settings = {
	  //輸出格式
	  output:renderer,
	  //背景色
	  bgColor: "#FFFFFF",
	  //barcode圖形顏色
	  color: "#000000",
	  //寬度
	  barWidth: 1,
	  //高度
	  barHeight: 50,
	  //條碼的寬高尺寸,datamatrix種類才有作用
	  moduleSize: "50",
	  //是否顯示文字 true/false
	  showHRI: true,
	  //文字尺寸
	  fontSize: 10,
	  //canvas格式使用
	  posX: "10",
	  posY: "20",
	  //是否左右補白邊 true/false
	  addQuietZone: true,
	  //文字與barcode間距(50以下無間距)
	  marginHRI: 5
	};
	$("#barcodeTarget").html("").show().barcode(value, btype, settings);
});