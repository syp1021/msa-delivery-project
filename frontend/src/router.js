
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"

import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"


import HistoryView from "./components/HistoryView"
import HistoryViewDetail from "./components/HistoryViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/storeOrders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },


            {
                path: '/histories',
                name: 'HistoryView',
                component: HistoryView
            },
            {
                path: '/histories/:id',
                name: 'HistoryViewDetail',
                component: HistoryViewDetail
            },


    ]
})
