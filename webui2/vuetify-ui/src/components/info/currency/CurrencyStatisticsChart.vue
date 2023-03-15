<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'CurrencyInfoChart',
        extends: Line,
        data() {
            return {
                chartData: {
                    labels: this.currencyLabels,
                    datasets: [{
                        label: 'label',
                        data: this.currencyData,
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
            currencyLabels: {
                default: function() {
                    return [];
                }
            },
            currencyData: {
                default: function() {
                    return [];
                }
            },
            label: {
                default: 'label'
            }
        },
        mounted() {
            this.renderChart(this.chartData, this.options);
        }
    }
</script>