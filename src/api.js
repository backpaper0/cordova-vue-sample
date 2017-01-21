import axios from 'axios'

const searchUsers = ({ q, sort }) => {
  const executor = resolve => {
    axios.get('https://api.github.com/search/users', { params: { q, sort }})
      .then(res => resolve(res.data.items))
  }
  return new Promise(executor)
}

export default {
  searchUsers
}
