from django.conf.urls import patterns, include, url
from django.contrib import admin
from django.conf.urls import url, include
from rest_framework import routers
from backend import views

admin.autodiscover()

router = routers.DefaultRouter()
router.register(r'categorias', views.CategoriaViewSet)
router.register(r'projetos', views.ProjetoViewSet)
router.register(r'perguntas', views.PerguntaViewSet)
router.register(r'questionarios', views.QuestionarioViewSet)


urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'auditest.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),
    url(r'^', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
)
