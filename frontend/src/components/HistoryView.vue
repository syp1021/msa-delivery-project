<template>

    <v-data-table
        :headers="headers"
        :items="history"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'HistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderId", value: "orderId" },
                { text: "userId", value: "userId" },
                { text: "storeId", value: "storeId" },
                { text: "menuId", value: "menuId" },
                { text: "qty", value: "qty" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "storeStatus", value: "storeStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
            ],
            history : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/histories'))

            temp.data._embedded.histories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.history = temp.data._embedded.histories;
        },
        methods: {
        }
    }
</script>

