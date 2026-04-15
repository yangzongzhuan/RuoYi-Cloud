import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi"

export function listCustomer(query) {
  return request({
    url: '/customer/list',
    method: 'get',
    params: query
  })
}

export function getCustomer(id) {
  return request({
    url: '/customer/' + parseStrEmpty(id),
    method: 'get'
  })
}

export function addCustomer(data) {
  return request({
    url: '/customer',
    method: 'post',
    data: data
  })
}

export function updateCustomer(data) {
  return request({
    url: '/customer',
    method: 'put',
    data: data
  })
}

export function delCustomer(id) {
  return request({
    url: '/customer/' + id,
    method: 'delete'
  })
}

export function listCustomerCar(customerId) {
  return request({
    url: '/customer/car/list/' + customerId,
    method: 'get'
  })
}

export function getCustomerCar(id) {
  return request({
    url: '/customer/car/' + id,
    method: 'get'
  })
}

export function addCustomerCar(data) {
  return request({
    url: '/customer/car',
    method: 'post',
    data: data
  })
}

export function updateCustomerCar(data) {
  return request({
    url: '/customer/car',
    method: 'put',
    data: data
  })
}

export function delCustomerCar(id) {
  return request({
    url: '/customer/car/' + id,
    method: 'delete'
  })
}
