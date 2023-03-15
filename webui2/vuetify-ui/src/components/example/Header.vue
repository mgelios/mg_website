<template>
  <div id="header">
      <p>{{sideBarOpened}}</p>
      <p>{{headerText}}</p>
  </div>
</template>

<script>
export default {
  name: 'header',
  data: function(){
    return {
      sideBarOpened: false
    }
  },
  props: ['headerText']
}
</script>

<style>
</style>
