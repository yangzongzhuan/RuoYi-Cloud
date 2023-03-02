import request from '@/utils/request'

// 查询站点管理列表
export function listWebsite(query) {
  return request({
    url: '/collect/website/list',
    method: 'get',
    params: query
  })
}

// 查询站点管理详细
export function getWebsite(id) {
  return request({
    url: '/collect/website/' + id,
    method: 'get'
  })
}

// 新增站点管理
export function addWebsite(data) {
  return request({
    url: '/collect/website',
    method: 'post',
    data: data
  })
}

// 修改站点管理
export function updateWebsite(data) {
  return request({
    url: '/collect/website',
    method: 'put',
    data: data
  })
}

// 删除站点管理
export function delWebsite(id) {
  return request({
    url: '/collect/website/' + id,
    method: 'delete'
  })
}
