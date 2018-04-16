/**
 * Created by kingyee on 14-8-25.
 */
cordova.define("org.apache.cordova.close-view.CloseView", function (require, exports, module) {

    var cordova = require('cordova'),
        exec = require('cordova/exec');

    var CloseView = function () {

    };

    CloseView.prototype.closeCurrentView = function (success, fail, parameters)
    {
        exec(success, fail, 'NewView', 'closeCurrentView', parameters);
    };

    CloseView.prototype.openSucceed = function (success, fail, parameters)
    {
        exec(success, fail, 'NewView', 'openSucceed', parameters);
    };
    
    var kyeeCloseView = new CloseView();

    module.exports = kyeeCloseView;
});
