<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'FinanceChart',
        extends: Line,
        data() {
            return {
                dataSet: {
                    label: this.chartLabel,
                    data: [],
                    backgroundColor: '#7ac0c088',
                    borderColor: '#3f8c4a',
                    fill: 'start'
                },
                options: {
                    maintainAspectRatio: true,
                    responsive: true,
                    aspectRatio: this.aspectRatio,
                    tooltips: {
                        intersect: false,
                        mode: 'index'
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                            }
                        }]
                    }
                }
            }
        },
        props: {
            chartLabel: {
                default: 'currency'
            },
            aspectRatio: {
                default: 2
            },
            height: null,
            width: "100%",
            chartData: {
                type: Array,
                default: null
            }
        },
        mounted() {
            var dataLabels = [];
            if (this.chartData) {
                for (var i = 0; i < this.chartData.length; i++) {
                    dataLabels.push(this.chartData[i].date[2] + '-' + this.chartData[i].date[1]);
                    this.dataSet.data.push(this.chartData[i].rate.toFixed(4));
                }
            }

            var chartData = {
                labels: dataLabels,
                datasets: [
                    this.dataSet
                ]
            };

            this.renderChart(chartData, this.options);
        }
    }
</script>

<style>

</style>
