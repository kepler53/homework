import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Book from "@/views/BookList.vue";
import BookAdd from "@/views/BookWrite.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/book",
        name: "book",
        component: Book,
    },
    {
        path: "/book/write",
        name: "bookAdd",
        component: BookAdd,
    },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
