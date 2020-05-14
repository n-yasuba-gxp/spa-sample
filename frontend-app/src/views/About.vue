<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button v-on:click="showPets()">Show Pets</button>
    <p>{{ pets }}</p>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import { PetsApi, Pet } from '../openapi'

@Component
export default class About extends Vue {
  
  private pets: Pet[]
  private petsApi: PetsApi
  constructor(init?: Partial<Pet>){
    super();
    this.pets = []
    this.petsApi = new PetsApi()
  }

  private async showPets() {
    const response = await this.petsApi.listPets()
    this.pets = response.data
  }
}
</script>
