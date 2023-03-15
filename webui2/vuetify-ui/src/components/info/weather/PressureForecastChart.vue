<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'PressureForecastChart',
        extends: Line,
        data() {
            return {
                chartData: {
                    labels: this.pressureLabels,
                    datasets: [{
                        label: 'pressure',
                        data: this.pressureData,
                        backgroundColor: 'rgba(163,163,163,0.53)',
                        borderColor: '#a7a7a7',
                        fill: 'start'
                    }]
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
            height: null,
            width: {
                default: "100%"
            },
            aspectRatio: {
                default: 4
            },
            pressureLabels: {
                default: function() {
                    return [];
                }
            },
            pressureData: {
                default: function() {
                    return [];
                }
            }
        },
        mounted() {
            this.renderChart(this.chartData, this.options);
        }
    }
</script>