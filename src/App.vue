<template>
  <div id="app">
    <!--    头部-->
    <Header/>
    <div style="display: flex">
      <!--      左导航栏-->
      <LeftMenu/>
      <!--      主体部分-->
      <Home/>
      <router-view/>
    </div>
  </div>
</template>

<script>
  import Header from "./components/Header";
  import LeftMenu from "./components/LeftMenu";
  import Home from "./views/Home";

  export default {
    name: 'App',

    components: {
      Header,
      LeftMenu,
      Home
    }
  }
</script>

<style>

</style>
