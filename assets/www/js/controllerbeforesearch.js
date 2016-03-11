cordova.define("com.ionicframework.sideionic304115.OpenNative", function(require, exports, module) {

function OpenNative() {
};

OpenNative.prototype.open = function(callbackContext) {
    callbackContext = callbackContext || {};
    cordova.exec(callbackContext.success || null, callbackContext.error || null, "OpenNative", "open", []);

};

/**
 * Load Plugin
 */

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.openNative) {
    window.plugins.openNative = new OpenNative();
}

});
