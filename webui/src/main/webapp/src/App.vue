<template>
  <div id="app">
    <Header headerText="sometext"/>
    <HelloWorld/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Header from './components/Header.vue'

export default {
  name: 'app',
  components: {
    Header,
    HelloWorld
  }
}
</script>

<style>
</style>
