<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'ExampleChart',
        extends: Line,
        props: {
            chartdata: {
                type: Array,
                default: null
            },
            options: {
                type: Object,
                default: null
            }
        },
        mounted() {
            var dataSetOne = {
                label: 'max temp',
                data: []
            };
            var dataSetTwo = {
                label: 'min temp',
                data: []
            };
            var dataLabels = [];
            var lastMaxTemp = -250;
            var lastMinTemp = 250;
            var lastLabel = "";
            if (this.chartdata.length > 0){
                lastMaxTemp = this.chartdata[0].maximumTemperature;
                lastMinTemp = this.chartdata[0].minimalTemperature;
                lastLabel = this.chartdata[0].time.split("T")[0];
            }
            for (var i = 0; i < this.chartdata.length; i++) {
                if (this.chartdata[i].time.split("T")[0] !== lastLabel || i+1 == this.chartdata.length){
                    dataLabels.push(lastLabel);
                    dataSetOne.data.push(lastMaxTemp);
                    dataSetTwo.data.push(lastMinTemp);
                    lastMaxTemp = -250;
                    lastMinTemp = 250;
                }
                if (this.chartdata[i].maximumTemperature > lastMaxTemp) {
                    lastMaxTemp = this.chartdata[i].maximumTemperature;
                }
                if (this.chartdata[i].minimalTemperature < lastMinTemp) {
                    lastMinTemp = this.chartdata[i].minimalTemperature;
                }
                lastLabel = this.chartdata[i].time.split("T")[0];
            }
            var chartdataone = {
                labels: dataLabels,
                datasets: [
                    dataSetOne, 
                    dataSetTwo
                ]
            };
            this.renderChart(chartdataone, this.options);
        }
    }
</script>