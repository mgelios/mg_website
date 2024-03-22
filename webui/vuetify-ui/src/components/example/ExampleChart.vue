<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'ExampleChart',
        extends: Line,
        data() {
            return {
                dataSetOne: {
                    label: 'max temp',
                    data: []
                },
                dataSetTwo: {
                    label: 'min temp',
                    data: []
                },
                options: {
                    maintainAspectRatio: false,
                    responsive: true,
                }
            }
        },
        props: {
            chartdata: {
                type: Array,
                default: null
            }
        },
        mounted() {
            var dataLabels = [];
            var lastMaxTemp = -250;
            var lastMinTemp = 250;
            var lastLabel = "";
            if (this.chartdata && this.chartdata.length > 0){
                lastMaxTemp = this.chartdata[0].maximumTemperature;
                lastMinTemp = this.chartdata[0].minimalTemperature;
                lastLabel = this.chartdata[0].time.split("T")[0];
            }
            if (this.chartdata) {
                for (var i = 0; i < this.chartdata.length; i++) {
                    if (this.chartdata[i].time.split("T")[0] !== lastLabel || i + 1 == this.chartdata.length) {
                        dataLabels.push(lastLabel);
                        this.dataSetOne.data.push(lastMaxTemp);
                        this.dataSetTwo.data.push(lastMinTemp);
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
            }
            var chartdataone = {
                labels: dataLabels,
                datasets: [
                    this.dataSetOne, 
                    this.dataSetTwo
                ]
            };
            this.renderChart(chartdataone, this.options);
        }
    }
</script>