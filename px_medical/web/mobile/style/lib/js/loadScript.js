var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, (pathName.substring(1).indexOf('/') + 1));
var arrayJs = [
		'<script src="' + rootPath + '/mobile/style/lib/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>',
		'<script src="' + rootPath + '/mobile/style/lib/js/dropload.js" type="text/javascript"></script>',
		'<script src="' + rootPath + '/mobile/style/lib/js/html5.js" type="text/javascript"></script>',
		'<script src="' + rootPath + '/mobile/style/lib/js/ui.js" type="text/javascript"></script>',
		'<script src="' + rootPath + '/mobile/style/lib/laydate/laydate.js" type="text/javascript"></script>',
		'<script src="' + rootPath + '/mobile/style/lib/js/common.js" type="text/javascript"></script>' ]
document.write(arrayJs.join(''));