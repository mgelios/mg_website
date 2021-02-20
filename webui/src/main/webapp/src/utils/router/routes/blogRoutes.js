import Blog from "../../../components/blog/Blog";
import Test from "../../../components/blog/pages/Test";
import BlogCategories from "../../../components/blog/pages/Categories";

import { pages } from "../pages";

export const blogRoutes = {
    path: '/blog',
    name: pages.BlogMain,
    component: Blog,
    children: [
        {
            path: 'test',
            name: pages.Blog,
            component: Test
        },
        {
            path: 'categories',
            name: 'categoriesPage',
            component: BlogCategories
        }
    ]
};