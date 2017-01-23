import Vue from 'vue'
import Vuex from 'vuex'
import api from './api'

Vue.use(Vuex)

const state = {
  q: '',
  sort: '',
  users: [],
  mode: ''
}

const mutations = {
  setUsers: (state, users) => state.users = users
  ,setQ: (state, q) => state.q = q
  ,setSort: (state, sort) => state.sort = sort
  ,setMode: (state, mode) => state.mode = mode
}

const actions = {
  searchUsers ({ commit }, payload) {
    return api.searchUsers(payload).then(x => commit('setUsers', x))
  },
  save ({ commit }, { q, sort }) {
    commit('setQ', q)
    commit('setSort', sort)
  },
  setMode ({ commit }, { mode }) {
    commit('setMode', mode)
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions
})

