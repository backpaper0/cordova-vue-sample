import Vue from 'vue'
import Vuex from 'vuex'
import api from './api'

Vue.use(Vuex)

const state = {
  users: []
}

const mutations = {
  setUsers: (state, users) => state.users = users
}

const actions = {
  searchUsers ({ commit }, q) {
    const executor = resolve => {
      api.searchUsers(q)
        .then(x => { 
          commit('setUsers', x)
          resolve()
        })
    }
    return new Promise(executor)
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions
})

