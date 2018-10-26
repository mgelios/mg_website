<template>
    <div class="holder">
      <h2>Hi</h2>
      <form v-on:submit.prevent="addSkill">
        <input type="text" placeholder="Enter you skill here" v-model="skill"/>
      </form>
      <ul>
        <li v-for="(data, index) in skills" :key='index'>{{index}}. {{data.skill}}</li>

        <p v-if="skills.length >= 1">You have more than on skill</p>
        <p v-else>You have one or less skills</p>
      </ul>
    </div>
</template>

<script>
export default {
  name: 'Skills',
  data: function(){
    return {
      skill: '',
      skills: [
          {"skill": "Vue.js"},
          {"skill": "Spring boot"}
      ]
    }
  },
  methods: {
    addSkill: function() {
      this.skills.push({skill: this.skill});
      this.skill = '';
    }
  },
  props: {
    btnState: true
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
