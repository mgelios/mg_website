<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'WeatherForecastCard',
        extends: Line,
        data() {
            return {
                dataSetOne: {
                    label: 'min temp',
                    data: [],
                    backgroundColor: '#7ac0c088',
                    borderColor: '#7ac0c0',
                    fill: 'start'
                },
                dataSetTwo: {
                    label: 'max temp',
                    data: [],
                    backgroundColor: '#e6896688',
                    borderColor: '#e68966',
                    fill: '0'
                },
                options: {
                    maintainAspectRatio: true,
                    responsive: true,
                    aspectRatio: this.aspectRatio,
                    tooltips: {
                        intersect: false,
                        mode: 'index'
                    }
                }
            }
        },
        props: {
            chartdata: {
                type: Array,
                default: null
            },
            height: null,
            width: "100%",
            aspectRatio: {
                default: 2
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
                lastLabel = this.chartdata[0].time[2];
            }
            if (this.chartdata) {
                for (var i = 0; i < this.chartdata.length; i++) {
                    if (this.chartdata[i].time[2] !== lastLabel || i + 1 == this.chartdata.length) {
                        dataLabels.push(lastLabel);
                        this.dataSetOne.data.push(lastMinTemp);
                        this.dataSetTwo.data.push(lastMaxTemp);
                        lastMaxTemp = -250;
                        lastMinTemp = 250;
                    }
                    if (this.chartdata[i].maximumTemperature > lastMaxTemp) {
                        lastMaxTemp = this.chartdata[i].maximumTemperature;
                    }
                    if (this.chartdata[i].minimalTemperature < lastMinTemp) {
                        lastMinTemp = this.chartdata[i].minimalTemperature;
                    }
                    lastLabel = this.chartdata[i].time[2];
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