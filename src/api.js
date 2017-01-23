import axios from 'axios'

const searchUsers = ({ q, sort }) =>
  axios.get('https://api.github.com/search/users', { params: { q, sort }})
       .then(res => res.data.items)

export default {
  searchUsers
}
