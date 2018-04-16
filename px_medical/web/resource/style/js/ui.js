/**
 * Created by Administrator on 2017-10-16.
 */
$(document).ready(function () {

    //switch 单选、复选插件
    $(".switch").click(function () {
        if ($(".switch-left").hasClass('chosen') == true) {
            $(".switch-left").removeClass('chosen');
            $("input[name=male]").attr("checked", false);
            $(".switch-right").addClass('chosen');
            $("input[name=female]").attr("checked", true);
        } else {
            $(".switch-right").removeClass('chosen');
            $("input[name=female]").attr("checked", false);
            $(".switch-left").addClass('chosen');
            $("input[name=male]").attr("checked", true);
        }
    });

    //下拉表单 选择框美化插件
    var config = {
        '.chosen-select': {},
        '.chosen-select-deselect': {
            allow_single_deselect: true
        },
        '.chosen-select-no-single': {
            disable_search_threshold: 10
        },
        '.chosen-select-no-results': {
            no_results_text: 'Oops, nothing found!'
        },
        '.chosen-select-width': {
            width: "100%"
        }
    };
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    };

    //复选框、单选美化
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });


    //**********bootsrtap table 分页不显示计数 **********
    $('span.page-list').css("display","none");
});

//重新渲染 iCheck 插件 
function iCheckApply() {
    //复选框、单选美化
    $('.i-checks').iCheck({
        checkboxClass : 'icheckbox_square-green',
        radioClass : 'iradio_square-green',
    });
}