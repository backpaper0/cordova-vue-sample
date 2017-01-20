import axios from 'axios'

const searchUsers = q => {
  const executor = resolve => {
    axios.get('https://api.github.com/search/users', { params: { q }})
      .then(res => resolve(res.data.items))
  }
  return new Promise(executor)
}

export default {
  searchUsers
}
