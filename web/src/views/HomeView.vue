<template>
  <ContentBase>
    首页
  </ContentBase>
  <PreCautions />

  

</template>


<script>
import ContentBase from '@/components/ContentBase.vue';
import PreCautions from '@/components/PreCautions.vue';

export default{
  name: 'HomeView',
  components: {
    ContentBase,
    PreCautions,
  }
}
</script>

<style scoped>
</style>