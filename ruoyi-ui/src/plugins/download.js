import { saveAs } from 'file-saver'
import axios from 'axios'
import { getToken } from '@/utils/auth'

const baseURL = process.env.VUE_APP_BASE_API

export default {
  zip(url, name) {
    var url = baseURL + url
    axios({
      method: 'get',
      url: url,
      responseType: 'blob',
      headers: { 'Authorization': 'Bearer ' + getToken() }
    }).then(res => {
      const blob = new Blob([res.data], { type: 'application/zip' })
      this.saveAs(blob, name)
    })
  },
  saveAs(text, name, opts) {
    saveAs(text, name, opts);
  }
}

