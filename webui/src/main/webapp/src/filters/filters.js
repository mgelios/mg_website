import Vue from 'vue'

Vue.filter('capitalize', function(string) {
    if (!string)
        return '';
    string = string.toString();
    return string.charAt(0).toUpperCase() + string.slice(1);
});

Vue.filter('degreeCelsius', function(value) {
    var string = "";
    if (!value) return '';
    if (value > 0) {
        string = "+";
    }
    string = string + value.toString() + "°C";
    return string;
});

Vue.filter('byn', function(value) {
    return '' + value.toFixed(2) + ' BYN';
});
