/**
 * Created by kingyee on 14-8-25.
 */
cordova.define("org.apache.cordova.file-operation.FileOperation", function (require, exports, module) {

    var cordova = require('cordova'),
        exec = require('cordova/exec');

    var FileOperation = function () {

    };

    FileOperation.prototype.writeAsArrayBuffer = function (success, fail, parameters)
    {
        exec(success, fail, 'FileOperation', 'writeAsArrayBuffer', parameters);
    };
    
    var kyeeFileOperation = new FileOperation();

    module.exports = kyeeFileOperation;
});
