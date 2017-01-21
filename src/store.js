import Vue from 'vue'
import Vuex from 'vuex'
import api from './api'

Vue.use(Vuex)

const state = {
  q: '',
  sort: '',
  users: []
}

const mutations = {
  setUsers: (state, users) => state.users = users
  ,setQ: (state, q) => state.q = q
  ,setSort: (state, sort) => state.sort = sort
}

const actions = {
  searchUsers ({ commit }, payload) {
    return api.searchUsers(payload).then(x => commit('setUsers', x))
  },
  save ({ commit }, { q, sort }) {
    commit('setQ', q)
    commit('setSort', sort)
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions
})

