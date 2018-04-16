//自定义的基本图表基础配置，无数据列
//baseColumnOpts柱状图
var baseColumnOpts = {
        chart: {
            type: 'column',                          //指定图表的类型，默认是折线图（line）
            reflow :true
        },
        legend: {
            enabled: true
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                allowPointSelect: true,
                animation:true,
                //colorByPoint: true, 按点/分类区分颜色
                dataLabels: {
                enabled: true //    ,format: '{point.y:.1f}%'
                }
            }
        },
        yAxis: {
            title: {
                text: '数量'                // y 轴标题
            }
        },
        xAxis: {
            title: {
                style: 'class1'                // x 轴标题
            }
        }
    };
//base end baseColumnOpts

//basePieOpts
//饼图
    var  basePieOpts = {
        chart: {
            type: 'pie',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: ''
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true
                },
                showInLegend: true
            }
        },
        series: [{
            name: '饼图',
            data: [
            ]
        }]
    };
//base end basePieOpts
