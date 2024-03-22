import Vue from 'vue'

Vue.filter('capitalize', function(string) {
    if (!string)
        return '';
    string = string.toString();
    return string.charAt(0).toUpperCase() + string.slice(1);
});

Vue.filter('degreeCelsius', function(value) {
    let resultString = "";
    if (!value) return '';

    let adjustedValue = value.toFixed(2);

    if (adjustedValue > 0) {
        resultString = "+";
    }
    resultString = resultString + adjustedValue.toString() + "°C";
    return resultString;
});

Vue.filter('byn', function(value) {
    return '' + value.toFixed(2) + ' BYN';
});

Vue.filter('twoDigitsAfterPoint', function(value) {
    return '' + value.toFixed(2);
});
