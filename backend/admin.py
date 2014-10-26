from django.contrib import admin

# Register your models here.
from backend.models import Projeto, Categoria, Pergunta, Questionario, QuestionarioPergunta, Resposta


class ProjetoAdmin(admin.ModelAdmin):
    fields = ('nome',)
    list_display = ('projeto_id','nome')
    search_fields = ['name']

class CategoriaAdmin(admin.ModelAdmin):
    fields = ('nome',)
    list_display = ('categoria_id','nome')
    search_fields = ['name']

class PerguntaAdmin(admin.ModelAdmin):
    fields = ('enunciado', 'categoria')
    list_display = ('pergunta_id','enunciado', 'categoria')
    search_fields = ['name']

class QuestionarioAdmin(admin.ModelAdmin):
    fields = ('nome','projeto_id')
    list_display = ('questionario_id','nome','projeto_id')
    search_fields = ['name']

class QuestionarioPerguntaAdmin(admin.ModelAdmin):
	fields = ('questionario_id','pergunta_id')
	list_display = ('questionario_id','pergunta_id')
	search_fields = ['name']

class RespostaAdmin(admin.ModelAdmin):
	fields = ('pergunta_id','usuario_id','valor_resposta','data_hora')
	list_display = ('pergunta_id','usuario_id','valor_resposta','data_hora')
	search_fields = ['name']

admin.site.register(Projeto,ProjetoAdmin)
admin.site.register(Categoria, CategoriaAdmin)
admin.site.register(Pergunta, PerguntaAdmin)
admin.site.register(Questionario, QuestionarioAdmin)
admin.site.register(QuestionarioPergunta, QuestionarioPerguntaAdmin)
admin.site.register(Resposta, RespostaAdmin)